package com.ittechoffice.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
