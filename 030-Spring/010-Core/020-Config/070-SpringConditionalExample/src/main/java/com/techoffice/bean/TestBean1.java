package com.techoffice.bean;

import org.springframework.stereotype.Component;

@Component
public class TestBean1 implements TestBean{
	
	private String name = "Test Bean 1";
	
	public String getName(){
		return name;
	}
}
