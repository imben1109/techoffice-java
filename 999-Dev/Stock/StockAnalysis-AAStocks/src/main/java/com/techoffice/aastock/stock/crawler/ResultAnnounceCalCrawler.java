package com.techoffice.aastock.stock.crawler;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.InvalidDocumentException;
import com.techoffice.util.exception.XpathException;

/**
 * Web Crawler for http://www.aastocks.com/en/stocks/market/calendar.aspx?type=1
 * @author imben1109
 *
 */
@Service
public class ResultAnnounceCalCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/calendar.aspx?type=1";
	
	public int getPageCount() throws XpathException {
		String xml = WebDriverUtil.getXml(URL);
		String xPath = "/html/body/form/div[2]/div[6]/div[8]/table/tbody/tr/td[2]/a";
		NodeList tableNodeList = XmlUtil.evaluateXpath(xml, xPath);
		int pageCount = tableNodeList.getLength() + 1;
		return pageCount;
	}
	
	
}
