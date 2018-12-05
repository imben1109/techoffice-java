package com.techoffice.bean;

import org.springframework.stereotype.Component;

@Component
public class TestBean2  {
	
	private String name = "Test Bean 2";
	
	public String getName(){
		return name;
	}
}
