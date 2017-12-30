package com.techoffice.etnet.news.crawler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.etnet.news.model.AvailableNewsDate;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

/**
 * HKET News Crawler 
 * 
 * http://inews.hket.com/sran001
 * 
 * @author TechOffice
 *
 */
@Component
public class ImmediateNewsCrawler {

	public String getXml(){
		return WebDriverUtil.getXml("http://inews.hket.com/sran001");
	}
	
	public String getXml(String url){
		return WebDriverUtil.getXml(url);		
	}
	
	public List<String> getNewsList(){
		return getNewsList(null);
	}
	
	public List<String> getNewsList(String url){
		String xml = null;
		if (url == null){
			xml = getXml();
		}else {
			xml = getXml(url);
		}
		List<String> newsList = XmlUtil.getNodeListText(xml, "//*[@id='eti-inews-list']/tbody/tr/td/a");
		return newsList;
	}
	
	public List<AvailableNewsDate> getAvailableDateList(){
		String xml = getXml();
		List<AvailableNewsDate> availNewsDateList = new ArrayList<AvailableNewsDate>();
		NodeList nodeList = XmlUtil.evaluateXpath(xml, "/html/body/div/div[4]/div[1]/div[2]/select/option");
		for (int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			String desc = XmlUtil.getNodeText(node);
			String url = XmlUtil.getNodeText(node.getAttributes().getNamedItem("value"));
			AvailableNewsDate availableNewsDate = new AvailableNewsDate();
			availableNewsDate.setDesc(desc);
			availableNewsDate.setUrl(url);
			availNewsDateList.add(availableNewsDate);
		}
		return availNewsDateList;
	}
}
