package com.techoffice.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtil {

	
	
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
	
    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
        	
        	@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        		return o1.getValue().compareTo(o2.getValue());
			}
        	
		}.reversed());
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry: list){
        	sortedMap.put(entry.getKey(), entry.getValue());
        }
		return sortedMap;
    }
    
    public static Map<String, Integer> getTop(Map<String, Integer> map, int n){
        Map<String, Integer> topMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry: map.entrySet()){
        	if (n > 0){
        		topMap.put(entry.getKey(), entry.getValue());
        		n--;
        	}
        }
        return topMap;
    }
}
