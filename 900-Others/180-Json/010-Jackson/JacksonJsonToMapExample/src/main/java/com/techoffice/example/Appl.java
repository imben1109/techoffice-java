package com.techoffice.example;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This example show how to use Jackson to convert Json to Map
 * 
 * @author Ben_c
 *
 */
public class Appl {
	public static void main(String[] args) throws IOException{
		String jsonStr = "{\"name\":\"Tech Office Jackson Example\", \"desc\": \"This is an example of Tech Office to show you how to convert JSON to Map\"}";
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(jsonStr, new TypeReference<Map<String, String>>(){});
		System.out.println(map.get("name"));
		System.out.println(map.get("desc"));
	}
}
