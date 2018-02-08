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
public class HelloWorldExample {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	public static void main(String[] args){
		System.out.println(SystemConfig.getValue());
	}
}
