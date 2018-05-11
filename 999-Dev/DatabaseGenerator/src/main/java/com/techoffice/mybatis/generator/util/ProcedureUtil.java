package com.techoffice.mybatis.generator.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.techoffice.oracle.convertor.ArgumentConvertor;

public class ProcedureUtil {

	private ProcedureUtil(){}
	
	private static Map<String, List<Map<String, String>>> cache = new ConcurrentHashMap<String, List<Map<String, String>>>(); 
	
	private static List<Map<String, String>> getValueFromCache(String packageName, String procedureName){
		String key = packageName + "_" + procedureName;
		return cache.get(key);
	}
	
	private static synchronized void setValueToCache(String packageName, String procedureName, List<Map<String, String>> object){
		String key = packageName + "_" + procedureName;
		cache.put(key, object);
	}
	
	public static synchronized List<Map<String, String>> getArgumentList(String packageName, String procedureName){
		List<Map<String, String>> cached = getValueFromCache(packageName, procedureName);
		if (cached != null ){
			return cached;
		}
		
		List<Map<String, String>> argumentList = ArgumentConvertor.getDataMap(packageName, procedureName);
		setValueToCache(packageName, procedureName, argumentList);
		
		return argumentList;
	}
}
