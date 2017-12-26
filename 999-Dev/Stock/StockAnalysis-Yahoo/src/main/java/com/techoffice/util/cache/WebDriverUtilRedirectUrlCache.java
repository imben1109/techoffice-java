package com.techoffice.util.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebDriverUtilRedirectUrlCache {

	private static final Map<String, String> cache = new ConcurrentHashMap<String, String>();

	private WebDriverUtilRedirectUrlCache(){}

	public static String get(String key){
		return cache.get(key);
	}
	
	public static void put(String key, String xml){
		cache.put(key, xml);
	}
	
	public static void clear(){
		cache.clear();
	}
}
