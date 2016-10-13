package com.ittechoffice.example.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class TestingSpringComponentBeanA {
	private String name = "Testing Spring Component Bean A";
	
	public String getName(){
		return name;
	}
}
