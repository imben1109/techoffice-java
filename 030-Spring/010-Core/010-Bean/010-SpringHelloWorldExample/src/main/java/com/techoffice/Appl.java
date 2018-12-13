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
public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	/**
	 * Main Program 
	 * @param args
	 */
	public static void main(String[] args){
		TestBean testBean = context.getBean(TestBean.class);
		System.out.println(testBean.getMessage());
	}
}
