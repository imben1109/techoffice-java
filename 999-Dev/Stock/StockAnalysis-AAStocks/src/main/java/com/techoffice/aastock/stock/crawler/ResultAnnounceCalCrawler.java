package com.techoffice.aastock.stock.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

/**
 * A Web Crawler for 
 * http://www.aastocks.com/en/stocks/market/calendar.aspx?type=1
 * 
 * @author imben1109
 *
 */
@Component
public class ResultAnnounceCalCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/calendar.aspx?type=1";
	
	public int getPageCount() {
		String xml = WebDriverUtil.getXml(URL);
		String xPath = "/html/body/form/div[2]/div[6]/div[8]/table/tbody/tr/td[2]/a";
		int pageCount = 1;
		try{
			NodeList tableNodeList = XmlUtil.evaluateXpath(xml, xPath);
			pageCount = tableNodeList.getLength() + 1;
		} catch(Exception e){
			// do nothing
		}
		return pageCount;
	}
	
	
}
