package com.techoffice.util;

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

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.techoffice.util.exception.RssUtilException;

public class RssUtil {

	private RssUtil(){}
	
	public static List<String> getContentList(String urlStr){
		try {
			List<String> contentList = new ArrayList<String>();
			URL url = new URL(urlStr);
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
		} catch (Exception e) {
			throw new RssUtilException(e);
		}
	}
	
	public static Map<String, Integer> getTopContentMap(String urlStr, int subStrLength, int top){
		List<String> contentList = getContentList(urlStr);
		Map<String, Integer> statisticsMap = new HashMap<String, Integer>();
		List<String> chineseContentList = ChineseUtil.getChineseContentList(contentList);
		for (String chineseContent: chineseContentList){
			List<String> substrList = StringUtil.getSubstrList(chineseContent, subStrLength);
			for (String substr: substrList){
				MapUtil.addCount(statisticsMap, substr);
			}
		}
		Map<String, Integer> topSortedStatisticMap = MapUtil.getTopSortedMap(statisticsMap, top);
		return topSortedStatisticMap;
	}
}
