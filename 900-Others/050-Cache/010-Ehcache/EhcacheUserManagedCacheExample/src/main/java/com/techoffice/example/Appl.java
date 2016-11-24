package com.techoffice.example;

import org.ehcache.UserManagedCache;
import org.ehcache.config.builders.UserManagedCacheBuilder;

public class Appl {
	public static void main(String[] args) {

		// Create Cache Manager 
		UserManagedCache<Long, String> userManagedCache = UserManagedCacheBuilder.
				newUserManagedCacheBuilder(Long.class, String.class).build(false);
		userManagedCache.init();
		
		// Put data into cache
		userManagedCache.put(1L, "Simple Ehcahce");
		System.out.println(userManagedCache.get(1L));
		// Close the Cache Manager
		userManagedCache.close(); 
	}
}
