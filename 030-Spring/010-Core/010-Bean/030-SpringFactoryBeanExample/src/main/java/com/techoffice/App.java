package com.techoffice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * A Simple Spring Inversion of Control Simple through XML Configuration File (ClassPathXmlApplicationContext) 
 * 
 * @author Ben_c
 *
 */
public class App {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	/**
	 * Main Program 
	 * @param args
	 */
	public static void main(String[] args){
		HelloWorld helloWorldExample = context.getBean(HelloWorld.class);
		System.out.println(helloWorldExample.getMessage());
	}
}
