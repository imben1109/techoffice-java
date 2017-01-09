package com.techoffice.example;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {
	private String hello = "Hello123!!";
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getHello(){
		return hello;
	}
	

}
