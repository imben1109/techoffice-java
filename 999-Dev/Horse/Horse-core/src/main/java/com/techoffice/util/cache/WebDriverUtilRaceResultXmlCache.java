package com.techoffice.util.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebDriverUtilRaceResultXmlCache {

	private static final Map<String, String> cache = new ConcurrentHashMap<String, String>();
	
	private WebDriverUtilRaceResultXmlCache(){}
	
	public static String get(String url){
		return cache.get(url);
	}
	
	public static void put(String url, String xml){
		cache.put(url, xml);
	}
	
	public static void clear(){
		cache.clear();
	}
}
