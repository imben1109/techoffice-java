package com.techoffice.rss;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.techoffice.util.RssUtil;


public class OnccNewsRss {
	
	private static final String ONCC_NEWS_RSS_URL = "http://news.on.cc/ncnews/rss/fin_news.xml";

	public static List<String> getContentList() throws ParserConfigurationException, IOException, SAXException {
		return RssUtil.getContentList(ONCC_NEWS_RSS_URL);
	}
	
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{
		Map<String, Integer> topContentMap = RssUtil.getTopContentMap(ONCC_NEWS_RSS_URL, 2, 10);
		for (Map.Entry<String, Integer> entry: topContentMap.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue() );
		}
	}
}
