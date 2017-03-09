package com.techoffice.common.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	public static Map<String, Object> toMap(String str){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = mapper.readValue(str, new TypeReference<Map<String, Object>>(){});
		} catch (Exception e) {
			System.err.println("Cannot convert Json to Map");
		}
		return map;
	}
	
}
