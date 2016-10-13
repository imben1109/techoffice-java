package com.ittechoffice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleSpringService {
	
	@Autowired
	private SimpleSpringBean simpleSpringBean;
	
	public String test(){
		return "Test";
	}
}
