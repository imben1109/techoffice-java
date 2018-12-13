package com.techoffice.bean;

import org.springframework.stereotype.Component;

import com.techoffice.RegisterConditional;

@RegisterConditional(value =  TestBean2.class )
@Component
public class TestBean2 implements TestBean{

	private String name = "Test Bean 2";
	
	public String getName(){
		return name;
	}
}
