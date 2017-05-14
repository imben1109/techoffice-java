package com.techoffice.jc.horse.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.techoffice.jc.horse.helper.RaceResultHelper;
import com.techoffice.jc.horse.model.RaceDate;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.jc.horse.model.RaceResultQueue;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.DocumentConversionException;
import com.techoffice.util.exception.XpathException;

@Component
public class RaceResultCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static final String HOST = "http://racing.hkjc.com";
	public static final String LOCATION = "/racing/Info/meeting/Results/English/";	
	
	public String retrieveXml() {
        return retrieveXml(LOCATION);
	}
	
	public String retrieveXml(String location) {
        String xml = WebDriverUtil.getRaceResultXml(HOST + location);
        return xml;
	}
	
	public List<RaceDate> retrieveRaceDateList() throws XpathException, ParseException {
		List<RaceDate> raceDateList = new ArrayList<RaceDate>();		
		String xml = retrieveXml();
		NodeList dateSelectList = XmlUtil.evaluateXpath(xml, "//*[@id='raceDateSelect']");
		Node dateSelect = dateSelectList.item(0);
		if (dateSelect != null){
			NodeList raceDatesNodeList = dateSelect.getChildNodes();
			for (int i=0; i<raceDatesNodeList.getLength(); i++){
				Node raceDateNode = raceDatesNodeList.item(i);
				if("option".equals(raceDateNode.getNodeName())){
					RaceDate raceDate = new RaceDate();
					String raceDateUrl = LOCATION + raceDateNode.getAttributes().getNamedItem("value").getNodeValue();
					String raceType = raceDateUrl.split("/")[6];
					String raceDateStr = raceDateUrl.split("/")[7];
					Date raceDateValue = RaceResultHelper.getRaceDate(raceDateStr);
					String venue = raceDateUrl.split("/")[8];
					raceDate.setUrl(raceDateUrl);
					raceDate.setRaceType(raceType);
					raceDate.setRaceDate(raceDateValue);
					raceDate.setVenue(venue);
					raceDateList.add(raceDate);
				}
			}
		}
		return raceDateList;
	}
	
	public List<RaceResultQueue> getRaceResultQueueList(String location) throws XpathException, ParseException {
		List<RaceResultQueue> raceNumList = new ArrayList<RaceResultQueue>();
		log.info("Retrieving XML from {}", location);
		String xml = retrieveXml(location);
		NodeList raceNumNodeList = XmlUtil.evaluateXpath(xml, "//*[@id='results']/div[2]/table/tbody/tr[1]/td");
		for (int i =0; i<raceNumNodeList.getLength() - 1; i++){
			Node raceNumTdNode = raceNumNodeList.item(i);
			if (raceNumTdNode.getChildNodes().getLength() >= 1){
				// The first node is #Text
				Node raceNumNode = raceNumTdNode.getChildNodes().item(0);
				if ("a".equals(raceNumNode.getNodeName())){
					String queueLocation = raceNumNode.getAttributes().getNamedItem("href").getNodeValue();
					log.info(queueLocation);
					String[] locationArr = queueLocation.split("/");
					Date raceDate = RaceResultHelper.getRaceDate(locationArr[7]);
					String raceType = locationArr[6];
					String venue = locationArr[8];
					String raceNum = locationArr[9];
					RaceResultQueue raceResultQueue = new RaceResultQueue();
					raceResultQueue.setLocation(queueLocation);
					raceResultQueue.setRaceDate(raceDate);
					raceResultQueue.setRaceType(raceType);
					raceResultQueue.setVenue(venue);
					raceResultQueue.setRaceNum(raceNum);
					raceNumList.add(raceResultQueue);
				}
			}
		}
		return raceNumList;
	}
	
	public RaceResult getRaceResult(String location) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XpathException, ParseException, DocumentConversionException {
		String xml = retrieveXml(location);
		RaceResult raceResult = RaceResultHelper.getRaceResult(xml, location);
		List<RaceResultHorse> raceResultHorseList = RaceResultHelper.getRaceResultHorseList(xml, raceResult);
		raceResult.setRaceResultHorseList(raceResultHorseList);
		return raceResult;
	}
	
}
