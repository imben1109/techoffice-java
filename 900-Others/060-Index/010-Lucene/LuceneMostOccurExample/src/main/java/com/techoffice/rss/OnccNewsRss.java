package com.techoffice.rss;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.techoffice.util.ChineseUtil;
import com.techoffice.util.StatisticsMapUtil;


public class OnccNewsRss {
	
	private static final String ONCC_NEWS_RSS_URL = "http://news.on.cc/ncnews/rss/fin_news.xml";

	public static List<String> getContentList() throws ParserConfigurationException, IOException, SAXException {
		List<String> contentList = new ArrayList<String>();
		URL url = new URL(ONCC_NEWS_RSS_URL);
		InputStream inputStream = url.openStream();
		InputSource inputSource = new InputSource(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(inputSource);
		NodeList nodeList = document.getElementsByTagName("description");
		for (int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			String content = node.getTextContent();
			contentList.add(content);
		}
		return contentList;
	}
	
	public static List<String> getChineseContentList() throws ParserConfigurationException, IOException, SAXException{
		List<String> chineseContentList = new ArrayList<String>();
		List<String> contentList = getContentList();
		for (String content: contentList){
			StringBuilder stringBuilder = new StringBuilder();
			for (int i=0 ; i<content.length(); i++){
				String str = content.substring(i, i+1);
				if (ChineseUtil.isChineseStr(str)){
					stringBuilder.append(str);
				}
			}
			chineseContentList.add(stringBuilder.toString());
		}
		return chineseContentList;
	}
	
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{
		Map<String, Integer> statisticsMap = new HashMap<String, Integer>();
		List<String> chineseContentList = getChineseContentList();
		for (String chineseContent: chineseContentList){
			List<String> substrList = ChineseUtil.getSubstrList(chineseContent, 2);
			for (String substr: substrList){
				StatisticsMapUtil.addCount(statisticsMap, substr);
			}
		}
		
		String maxKey = StatisticsMapUtil.getMaxCount(statisticsMap);
		System.out.println(maxKey);
		System.out.println(statisticsMap.get(maxKey));
	}
}
