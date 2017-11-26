package com.techoffice.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebpageUtil {

	private WebpageUtil(){}
	
	public static Map<String, Integer> getTopContentMap(String urlStr, int subStrLength, int top){
		List<String> contentList = UrlUtil.getContentList(urlStr);
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
