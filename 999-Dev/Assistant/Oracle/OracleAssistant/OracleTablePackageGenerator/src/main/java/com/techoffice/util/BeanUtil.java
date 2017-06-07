package com.techoffice.util;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BeanUtil {
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMap(Object obj){
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(obj, Map.class);
	}
}
