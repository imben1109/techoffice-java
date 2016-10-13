package com.ittechoffice.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	private String name = "helloService";
	
	public String getName(){
		return name;
	}
}
