package com.techoffice.example;

import java.net.URL;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

public class Appl {
	public static void main(String[] args) {
		final URL url = Appl.class.getClassLoader().getResource("ehcache.xml"); 
		XmlConfiguration xmlConfig = new XmlConfiguration(url); 
		CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
	    cacheManager.init();
		Cache basicCache = cacheManager.getCache("basicCache", Long.class, String.class);
		basicCache.put(1L, "Testing String");
		System.out.println(basicCache.get(1L));
	}
}
