package com.techoffice.rss;

import java.util.Map;

import com.techoffice.util.RssUtil;

public class EtnetRssSpecial {
	private static final String URL = "https://www.etnet.com.hk/www/tc/news/rss.php?section=commentary";
	
	public static void main(String[] args){
		Map<String, Integer> topContentMap = RssUtil.getTopContentMap(URL, 2, 10);
		for (Map.Entry<String, Integer> entry: topContentMap.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue() );
		}	}
}
