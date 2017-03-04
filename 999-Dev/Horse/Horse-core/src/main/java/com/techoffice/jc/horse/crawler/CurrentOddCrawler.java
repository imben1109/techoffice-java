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
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@Component
public class CurrentOddCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static final String HOST = "http://bet.hkjc.com/racing/pages/odds_wp.aspx?lang=en";
	
	@Autowired
	private HorseAdjTimeDao horseAdjTimeDao;
	
	@Autowired
	private DrawAccelerateTimeDao drawAccelerateTimeDao;
	
	public String retrieveXml() {
        return retrieveXml("");
	}
	
	public String retrieveXml(String location) {
		String currentUrl = WebDriverUtil.getCurrentUrl(HOST);
		log.info(currentUrl + location);
        String xml = WebDriverUtil.getXml(currentUrl + location);
        return xml;
	}
	
	public String retrieveXmlByRaceNum(String raceNum){
		String xml = retrieveXml("&raceno=" + raceNum.replace("Race ", ""));
		return xml;
	}

	public List<String> getRaceNums() throws XPathExpressionException, XmlUtilDocumentConversionException {
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
	
	public List<CurrentOdd> getCurrentOdd() throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		String xml = retrieveXml();
		return getOddsList(xml);
	}
	
	public List<CurrentOdd> getCurrentOddByRaceNum(String raceNum) throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		String xml = retrieveXmlByRaceNum(raceNum);
		return getOddsList(xml);
	}
	
	public void run() throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		List<String> raceNums = this.getRaceNums();
		for (String raceNum: raceNums){
			log.info("raceNum" + raceNum);
			getCurrentOddByRaceNum(raceNum);
		}
	}
	
	public List<CurrentOdd> getOddsList(String xml) throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException {
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
		oddsList= horseAdjTimeDao.getAdjTime(oddsList);
		Map<String, Double> drawTimeMap = drawAccelerateTimeDao.getDrawAccelerateTime(venue, course, distance);
		log.info(venue + " " + distance + " " + course) ;
		for (CurrentOdd odd: oddsList){
			Double drawTime = drawTimeMap.get(odd.getDraw());
			odd.setDrawTime(drawTime);
			if (odd.getAdjTime() != null){
				if (odd.getDrawTime() != null){
					Double calcTime = odd.getAdjTime() + drawTime;
					odd.setCalcTime(calcTime);		
				}else{
					odd.setCalcTime(odd.getAdjTime());		
				}
			}
		}
		Collections.sort(oddsList);
		for (CurrentOdd odd: oddsList){
			log.info(odd.getHorseName() + " " + odd.getCalcTime());
		}
		return oddsList;
	}
	
	

}
