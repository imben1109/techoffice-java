package com.techoffice.jc.horse.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
import com.techoffice.jc.horse.dao.DrawAccelerateTimeDao;
import com.techoffice.jc.horse.dao.HorseAdjTimeDao;
import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@Component
public class CurrentOddsCrawler {
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
        String xml = WebDriverUtil.getXml(HOST + location);
        return xml;
	}
	
	public void getRaceNums() throws XPathExpressionException, XmlUtilDocumentConversionException {
		String xml = retrieveXml();
		String xPath = "//*[@id='info_bar']/tbody/tr[2]/td/div/table/tbody/tr/td/a/img";
		NodeList nodeList = XmlUtil.evaluateXpath(xml, xPath);
		for (int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			Node titleNode = node.getAttributes().getNamedItem("title");
			System.out.println(titleNode.getTextContent());
		}
	}
	
	public void getHorses() throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException {
		String xml = retrieveXml();
		String xPath = "//*[@id='detailWPTable']/table/tbody/tr";
		NodeList nodeList = XmlUtil.evaluateXpath(xml, xPath);
		List<CurrentOdd> horseList = new ArrayList<CurrentOdd>();
		for (int i=1; i<nodeList.getLength()-1; i++){
			Node trNode = nodeList.item(i);
			CurrentOdd currentOdd = getNodeInfo(trNode);
			horseList.add(currentOdd);
		}
		String course = getCourse(xml);
		String distance = getDistance(xml);
		String venue = getVenue(xml);
		horseList= horseAdjTimeDao.getAdjTime(horseList);
		Map<String, Double> drawTimeMap = drawAccelerateTimeDao.getDrawAccelerateTime(venue, course, distance);
		System.out.println(venue + " " + distance + " " + course) ;
		for (CurrentOdd odd: horseList){
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
		Collections.sort(horseList);
		for (CurrentOdd odd: horseList){
			System.out.println(odd.getHorseName() + " " + odd.getCalcTime());
		}

	}
	
	private String getVenue(String xml) throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		String venueXpath = "//*[@id='trMeetingInfo']/td[2]/table/tbody/tr/td[4]/nobr[2]";
		String venueStr = XmlUtil.getXpathText(xml, venueXpath);
		if (venueStr.equals("Sha Tin")){
			return "Tin";
		}
		return "";
	}
	
	private String getCourse(String xml) throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		String trackXpath = "//*[@id='info_bar']/tbody/tr[3]/td/table/tbody/tr/td[3]/nobr[4]";
		String courseXpath = "//*[@id='info_bar']/tbody/tr[3]/td/table/tbody/tr/td[3]/nobr[3]";
		String courseStr = XmlUtil.getXpathText(xml, courseXpath);
		courseStr = courseStr.toUpperCase();
		String trackStr = XmlUtil.getXpathText(xml, trackXpath);
		trackStr = trackStr.toUpperCase();
		String course = trackStr + " - " + courseStr;
		return course;
	}
	
	private String getDistance(String xml) throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		String distanceXpath = "//*[@id='info_bar']/tbody/tr[3]/td/table/tbody/tr/td[3]/nobr[5]";
		String distanceStr = XmlUtil.getXpathText(xml, distanceXpath);
		distanceStr = distanceStr.toUpperCase();
		return distanceStr;
	}
	
	private CurrentOdd getNodeInfo(Node node){
		CurrentOdd currentOdd = new CurrentOdd();
		String horseFullName = "";
		int tdNodeSeq = 0;
		NodeList nodeList = node.getChildNodes();
		for (int i=0; i<nodeList.getLength(); i++){
			Node item = nodeList.item(i);
			if (item.getNodeName().equals("td")){
				tdNodeSeq++;
				Node tdNode = item;
				if (tdNodeSeq == 3){
					Node aNode = tdNode.getChildNodes().item(0);
					String hrefString = aNode.getAttributes().getNamedItem("href").getNodeValue();
					String horseId = hrefString.replace("javascript:WACommonTagging('horse');goHorseRecord2('http://www.hkjc.com/english',%20'", "").replace("');", "");
					String horseNmae= aNode.getChildNodes().item(0).getTextContent();
					horseFullName = horseNmae + " (" + horseId + ")";
					currentOdd.setHorseName(horseFullName);
				}
				if (tdNodeSeq == 4){
					String draw = tdNode.getTextContent();
					currentOdd.setDraw(draw);
				}
			}
		}
		return currentOdd;
	}

}
