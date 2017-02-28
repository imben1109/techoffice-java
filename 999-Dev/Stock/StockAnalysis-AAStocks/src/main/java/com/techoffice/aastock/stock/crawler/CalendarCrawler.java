package com.techoffice.aastock.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.factory.WebDriverFactory;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

@Service
public class CalendarCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/calendar.aspx";
	
	public String retrieveXmlFromWebClient() {
		String xml = WebDriverUtil.getXml(URL);
		return xml;
	}
	
	public String retrieveResultAnnounceXmlFromWebClient(String page) {
		String xml = "";
        if (page == null){
        	WebDriverUtil.getXml(URL+"?type=1");
        }else {
        	WebDriverUtil.getXml(URL + "?type=1&page=" + page);
        }
        return xml;
	}
	
	public void parseXml(String xml){
		String xPath = "/html/body/form/div[2]/div[6]/table[2]/tbody/tr";
	}
	
	public int getPageCount(String xml) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		String xPath = "/html/body/form/div[2]/div[6]/div[8]/table/tbody/tr/td[2]/a";
		NodeList tableNodeList = XmlUtil.evaluateXpath(xml, xPath);
		int pageCount = tableNodeList.getLength() + 1;
		return pageCount;
	}
}
