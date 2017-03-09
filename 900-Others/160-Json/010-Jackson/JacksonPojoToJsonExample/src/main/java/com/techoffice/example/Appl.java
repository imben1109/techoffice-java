package com.techoffice.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This example show how to use Jackson to convert POJO to JSON String.
 * 
 * @author Ben_c
 *
 */
public class Appl {
	public static void main(String[] args) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setUserid("001");
		user.setName("Test Name");
		String userJsonStr = mapper.writeValueAsString(user);
		System.out.println(userJsonStr);
	}
}
