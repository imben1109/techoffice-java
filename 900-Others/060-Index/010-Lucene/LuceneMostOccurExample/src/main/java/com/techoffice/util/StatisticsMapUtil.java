package com.techoffice.util;

import java.util.Map;

public class StatisticsMapUtil {

	public static void addCount(Map<String, Integer> map, String key){
		Integer count = map.get(key);
		if (count == null){
			map.put(key, 1);
		}else{
			count++;
			map.put(key, count);
		}
	}
	
	public static String getMaxCount(Map<String, Integer> map){
		int maxCount = 0; 
		String maxKey = null;
		for (String key: map.keySet()){
			if (map.get(key) > maxCount){
				maxCount = map.get(key);
				maxKey = key;
			}
		}
		return maxKey;
	}
}
