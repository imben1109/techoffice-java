package com.techoffice.aastock.stock.crawler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

/**
 * A Web Crawler for 
 * http://www.aastocks.com/en/stocks/news/aafn/top-news
 * 
 * @author imben1109
 *
 */
@Component
public class TopNewsCrawler {
	
	public static final String URL = "http://www.aastocks.com/en/stocks/news/aafn/top-news";
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public String retrieve(){
		String xml = WebDriverUtil.getXml(URL, true);
		return xml;
	}
	
	public List<String> getNewsList(){
		String xml = retrieve();
		List<String> newsList = new ArrayList<String>();
		String xPath = "//*[@id='aafn-search-c1']/div";
		NodeList nodeList = XmlUtil.evaluateXpath(xml, xPath);
		for (int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			String nodeText = XmlUtil.getNodeText(node);
			newsList.add(nodeText);
		}
		return newsList;
	}
}
