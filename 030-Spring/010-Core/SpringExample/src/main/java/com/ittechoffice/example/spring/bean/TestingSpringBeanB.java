package com.ittechoffice.example.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class TestingSpringBeanB {
	
	@Autowired
	TestingSpringBeanA testingSpringBeanA;
	
	public TestingSpringBeanA getTestingSpringBeanA(){
		return testingSpringBeanA;
	}
}
