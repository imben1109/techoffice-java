package com.techoffice.etnet.stock.crawler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

@Component
public class NewsCrawler {

	public String getXml(){
		return WebDriverUtil.getXml("http://inews.hket.com/sran001");
	}
	
	public List<String> getNewsList(){
		String xml = getXml();
		List<String> newsList = XmlUtil.getNodeListText(xml, "//*[@id='eti-inews-list']/tbody/tr/td/a");
		return newsList;
	}
}
