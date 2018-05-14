package com.techoffice.database.dao.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DaoQueryCacheUtil {

	private static Map<Class<?>, Map<String, List<?>>> cacheMap = new ConcurrentHashMap<Class<?>, Map<String, List<?>>>(); 
	
	private DaoQueryCacheUtil(){};
	
	public static synchronized Map<String, List<?>> getCache(Class<?> clazz){
		Map<String, List<?>> cache = cacheMap.get(clazz);
		if (cache != null){
			return cache;
		}
		cache = new ConcurrentHashMap<String, List<?>>();
		cacheMap.put(clazz, cache);
		return cache;
	}
	
	
}
