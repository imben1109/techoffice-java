package com.techoffice.jc.horse.crawler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.factory.WebDriverFactory;
import com.techoffice.jc.horse.dao.DrawAccelerateTimeDao;
import com.techoffice.jc.horse.dao.HorseAdjTimeDao;
import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.jc.horse.helper.CurrentOddHelper;
import com.techoffice.util.UrlUtil;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.DocumentConversionException;
import com.techoffice.util.exception.XpathException;

/**
 * Current Odd Crawler 
 * 
 * It crawls http://bet.hkjc.com/racing/pages/odds_wp.aspx?lang=en
 * 	and retrieve current odd data 
 * 
 * @author imben1109
 *
 */
@Component
public class CurrentOddCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static final String HOST = "http://bet.hkjc.com/racing/pages/odds_wp.aspx?lang=en";
	
	/**
	 * 
	 * @return
	 */
	public String retrieveXml() {
        return retrieveXml("");
	}
	
	/**
	 * 
	 * @param location
	 * @return
	 */
	public String retrieveXml(String location) {
		String currentUrl = WebDriverUtil.getCurrentUrl(HOST);
		Map<String, String> params = UrlUtil.getParam(currentUrl);
		log.info("venue: " + params.get("venue"));
		log.info("date: " + params.get("date"));
		log.info("url: " + currentUrl + location);
        String xml = WebDriverUtil.getXml(currentUrl + location);
        return xml;
	}
	
	public String retrieveXmlByRaceNum(String raceNum){
		String xml = retrieveXml("&raceno=" + raceNum.replace("Race ", ""));
		return xml;
	}

	public List<String> getRaceNums() {
		List<String> raceNums = new ArrayList<String>();
		String xml = retrieveXml();
		String xPath = "//*[@id='info_bar']/tbody/tr[2]/td/div/table/tbody/tr/td/a/img";
		NodeList nodeList = XmlUtil.evaluateXpath(xml, xPath);
		for (int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			Node titleNode = node.getAttributes().getNamedItem("title");
			raceNums.add(titleNode.getTextContent());
		}
		return raceNums;
	}
	
	public List<CurrentOdd> getCurrentOdd() throws XPathExpressionException, DocumentConversionException, XpathException{
		String xml = retrieveXml();
		return getOddsList(xml);
	}
	
	public List<CurrentOdd> getCurrentOddByRaceNum(String raceNum) throws XPathExpressionException, DocumentConversionException, XpathException{
		String xml = retrieveXmlByRaceNum(raceNum);
		return getOddsList(xml);
	}
	
	public void run() throws XPathExpressionException, DocumentConversionException, XpathException{
		List<String> raceNums = this.getRaceNums();
		for (String raceNum: raceNums){
			log.info("raceNum" + raceNum);
			getCurrentOddByRaceNum(raceNum);
		}
	}
	
	public List<CurrentOdd> getOddsList(String xml) throws XPathExpressionException, DocumentConversionException, XpathException {
		String xPath = "//*[@id='detailWPTable']/table/tbody/tr";
		NodeList nodeList = XmlUtil.evaluateXpath(xml, xPath);
		List<CurrentOdd> oddsList = new ArrayList<CurrentOdd>();
		for (int i=1; i<nodeList.getLength()-1; i++){
			Node trNode = nodeList.item(i);
			CurrentOdd currentOdd = CurrentOddHelper.getNodeInfo(trNode);
			oddsList.add(currentOdd);
		}
		String course = CurrentOddHelper.getCourse(xml);
		String distance = CurrentOddHelper.getDistance(xml);
		String venue = CurrentOddHelper.getVenue(xml);
		log.info(venue + " " + distance + " " + course) ;
		return oddsList;
	}
	
	

}
