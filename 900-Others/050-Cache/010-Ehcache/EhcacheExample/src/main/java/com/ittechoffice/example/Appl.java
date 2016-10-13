package com.ittechoffice.example;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class Appl {
	public static void main(String[] args) {

		// Create Cache Manager 
		CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
		cacheManager.init();

		// Create Cache 
		ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.heap(10);
		CacheConfiguration<Long, String> cacheConfiguration = CacheConfigurationBuilder
				.newCacheConfigurationBuilder(Long.class, String.class, resourcePoolsBuilder).build();
		Cache<Long, String> simpleCache = cacheManager.createCache("simpleCache", cacheConfiguration);
		
		// Put data into cache
		simpleCache.put(1L, "Simple Ehcahce");
		
		// Get data from cache
		String value = simpleCache.get(1L); 
		System.out.println(value);
		
		// Close the Cache Manager
		cacheManager.close(); 
	}
}
