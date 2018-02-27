package com.techoffice.example;

import org.springframework.beans.factory.FactoryBean;

public class HelloWorldFactoryBean implements FactoryBean<HelloWorldExample>{

	private String message;
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public HelloWorldExample getObject() throws Exception {
		HelloWorldExample helloWorldExample = new HelloWorldExample();
		helloWorldExample.setMessage(message);
		return helloWorldExample;
	}

	public Class<HelloWorldExample> getObjectType() {
		return HelloWorldExample.class;
	}

	public boolean isSingleton() {
		return false;
	}

}
