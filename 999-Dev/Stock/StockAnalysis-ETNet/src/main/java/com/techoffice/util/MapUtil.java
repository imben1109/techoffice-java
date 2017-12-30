package com.techoffice.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Map Utility 
 * 
 * @author Tech Office
 *
 */
public class MapUtil {

	private MapUtil(){}
	
	/**
	 * Get Sorted Map by Comparator
	 * 
	 * @param map
	 * @param comparator
	 * @return sorted map
	 */
	public static <T extends Map<K, V>, K, V> Map<K, V> sort(T map, Comparator<Map.Entry<K, V>> comparator){
		LinkedHashMap <K, V> sortedMap = new LinkedHashMap<K, V>();
		
		List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, comparator);
		
		for (Map.Entry<K, V> entry: list){
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
	
	/**
	 * Get Sorted Map
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> sort(Map<String, Integer> map){
		return sort(map, new Comparator<Map.Entry<String, Integer>>(){
			
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
	}
	

}
