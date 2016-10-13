package com.ittechoffice.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ittechoffice.service.HelloService;

@Component
@ManagedBean
@SessionScoped
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	private String name = "Hello";
	
	public String getName(){
		return helloService.getName();
	}
}
