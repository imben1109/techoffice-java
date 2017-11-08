package com.techoffice.example;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This example show how to use Jackson to convert POJO to JSON String.
 * 
 * @author Ben_c
 *
 */
public class Appl {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setUserid("001");
		user.setName("Test Name");
		user.setDob(new Date());
		Map<String, Object> map = mapper.convertValue(user, Map.class);
		System.out.println(map.get("dob").getClass());
		
	}
}
