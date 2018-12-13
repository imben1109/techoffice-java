package com.techoffice;

import org.springframework.beans.factory.FactoryBean;

public class HelloWorldFactoryBean implements FactoryBean<HelloWorld>{

	private String message;
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public HelloWorld getObject() throws Exception {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMessage(message);
		return helloWorld;
	}

	public Class<HelloWorld> getObjectType() {
		return HelloWorld.class;
	}

	public boolean isSingleton() {
		return false;
	}

}
