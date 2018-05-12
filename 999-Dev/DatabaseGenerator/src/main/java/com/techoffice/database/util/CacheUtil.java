package com.techoffice.database.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheUtil {

	private static Map<Class<?>, Map<Object, Object>> cacheMap = new ConcurrentHashMap<Class<?>, Map<Object, Object>>(); 
	
	private CacheUtil(){};
	
	public static synchronized Map<Object, Object> getCache(Class<?> clazz){
		Map<Object, Object> cache = cacheMap.get(clazz);
		if (cache != null){
			return cache;
		}
		cache = new ConcurrentHashMap<Object, Object>();
		cacheMap.put(clazz, cache);
		return cache;
	}
	
	
}
