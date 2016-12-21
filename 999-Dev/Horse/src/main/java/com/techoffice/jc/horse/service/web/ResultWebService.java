package com.techoffice.jc.horse.service.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.jc.horse.service.web.helper.ResultWebServiceHelper;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@Component
public class ResultWebService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static final String HOST = "http://racing.hkjc.com";
	public static final String LOCATION = "/racing/Info/meeting/Results/English/";	
	
	@Autowired
	private WebClient webClient;
	
	public String retrieveXml() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
        return retrieveXml(LOCATION);
	}
	
	public String retrieveXml(String location) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
        final HtmlPage page = webClient.getPage(HOST + location);
        String xml = page.asXml();
        webClient.close();
        return xml;
	}
	
	public List<String> retrieveRaceDateList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		List<String> raceDateList = new ArrayList<String>();		
		String xml = retrieveXml();
		NodeList dateSelectList = XmlUtil.evaluateXpath(xml, "/html/body/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[2]/select");
		Node dateSelect = dateSelectList.item(0);
		NodeList raceDatesNodeList = dateSelect.getChildNodes();
		for (int i=0; i<raceDatesNodeList.getLength(); i++){
			Node raceDate = raceDatesNodeList.item(i);
			if("option".equals(raceDate.getNodeName())){
				raceDateList.add(LOCATION + raceDate.getAttributes().getNamedItem("value").getNodeValue());
			}
		}
		
		return raceDateList;
	}
	
	public List<String> getRaceNumList(String location) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		List<String> raceNumList = new ArrayList<String>();
		raceNumList.add(location);
		String xml = retrieveXml(location);
		NodeList raceNumNodeList = XmlUtil.evaluateXpath(xml, "/html/body/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td");
		for (int i =0; i<raceNumNodeList.getLength(); i++){
			Node raceNumTdNode = raceNumNodeList.item(i);
			if (raceNumTdNode.getChildNodes().getLength() > 1){
				// The first node is #Text
				Node raceNumNode = raceNumTdNode.getChildNodes().item(1);
				if ("a".equals(raceNumNode.getNodeName())){
					raceNumList.add(raceNumNode.getAttributes().getNamedItem("href").getNodeValue());
				}
			}
		}
		return raceNumList;
	}
	
	public RaceResult getRaceResult(String location) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilXpathNotUniqueException, ParseException{
		String xml = retrieveXml(location);
		RaceResult raceResult = ResultWebServiceHelper.getRaceResult(xml, location);
		List<RaceResultHorse> raceResultHorseList = ResultWebServiceHelper.getRaceResultHorseList(xml);
		raceResult.setRaceResultHorseList(raceResultHorseList);
		return raceResult;
	}
	
}
