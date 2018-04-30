package com.techoffice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloWorldExample {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	private String message;
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	
	/**
	 * Main Program 
	 * @param args
	 */
	public static void main(String[] args){
		HelloWorldExample helloWorldExample = context.getBean(HelloWorldExample.class);
		System.out.println(helloWorldExample.getMessage());
	}
}
