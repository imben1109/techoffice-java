package com.techoffice.jc.horse.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.jc.horse.helper.CurrentOddHelper;
import com.techoffice.util.UrlUtil;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

/**
 * Current Odd Crawler 
 * 
 * It crawls http://bet.hkjc.com/racing/pages/odds_wp.aspx?lang=en
 * 	and retrieve CurrentOdd data 
 *  * 
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
		String redirectUrl = WebDriverUtil.getRedirectUrl(HOST);
		Map<String, String> params = UrlUtil.getGetParamMap(redirectUrl);
		log.info("venue: " + params.get("venue"));
		log.info("date: " + params.get("date"));
		log.info("url: " + redirectUrl + location);
        String xml = WebDriverUtil.getXml(redirectUrl + location);
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
	
	public List<CurrentOdd> getCurrentOdd() {
		String xml = retrieveXml();
		return getOddsList(xml);
	}
	
	public List<CurrentOdd> getCurrentOddByRaceNum(String raceNum) {
		String xml = retrieveXmlByRaceNum(raceNum);
		return getOddsList(xml);
	}
	
	public void run() {
		List<String> raceNums = this.getRaceNums();
		for (String raceNum: raceNums){
			log.info("raceNum" + raceNum);
			getCurrentOddByRaceNum(raceNum);
		}
	}
	
	public List<CurrentOdd> getOddsList(String xml) {
		List<CurrentOdd> currentOddList = CurrentOddHelper.getCurrentOddList(xml);
		String course = CurrentOddHelper.getCourse(xml);
		String distance = CurrentOddHelper.getDistance(xml);
		String venue = CurrentOddHelper.getVenue(xml);
		String raceNum = CurrentOddHelper.getRaceNum(xml);
		String raceDateStr = CurrentOddHelper.getRaceDateStr(xml);
		for (CurrentOdd currentOdd: currentOddList){
			currentOdd.setCourse(course);
			currentOdd.setDistance(distance);
			currentOdd.setVenue(venue);
			currentOdd.setRaceNum(raceNum);
			currentOdd.setRaceDateStr(raceDateStr);
		}
		return currentOddList;
	}
	
}
