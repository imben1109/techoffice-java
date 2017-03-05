package com.techoffice.aastock.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.util.SpecialStringUtil;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.XmlUtilInvalidDocumentException;

@Component
public class IndustryPerformanceCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/industry/industry-performance.aspx";
		
	public String retrieveXml() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		String xml = WebDriverUtil.getXml(URL);
		return xml;
	}
	
	public List<String> retrieveIndustryList() throws FailingHttpStatusCodeException, MalformedURLException, IOException, XPathExpressionException, ParserConfigurationException, SAXException, XmlUtilInvalidDocumentException{
		String xml = retrieveXml();
		List<String> industryList = new ArrayList<String>();
		String xPath = "//*[@id='IndustyMain']/div[6]/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/a";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xPath);
		for (int i=0; i<rowNodeList.getLength(); i++){
			Node industryNode = rowNodeList.item(i);
			String industryName = industryNode.getTextContent();
			industryName = SpecialStringUtil.removeSpecialCharacter(industryName);
			industryList.add(industryName);
		}
		return industryList;
	}
}
