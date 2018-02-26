package com.techoffice.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * A Simple Spring Inversion of Control Simple through XML Configuration File (ClassPathXmlApplicationContext) 
 * 
 * @author Ben_c
 *
 */
public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	private String message;
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	public void run(){
		System.out.println(message);
	}
	
	/**
	 * Main Program 
	 * @param args
	 */
	public static void main(String[] args){
		Appl appl = SpringContextUtil.getBean(Appl.class);
		appl.run();
	}
}
