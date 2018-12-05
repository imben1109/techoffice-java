package com.techoffice.bean;

import org.springframework.stereotype.Component;

import com.techoffice.bean.intf.TestBean;

@Component
public class TestBean1 implements TestBean{
	
	private String name = "Test Bean 1";
	
	public String getName(){
		return name;
	}
}
