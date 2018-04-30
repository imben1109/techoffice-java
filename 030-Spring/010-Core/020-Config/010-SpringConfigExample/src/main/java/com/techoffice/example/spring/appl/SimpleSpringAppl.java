package com.techoffice.example.spring.appl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techoffice.example.spring.bean.TestingSpringBeanA;

/**
 * 
 * A Simple Spring Inversion of Control Simple through XML Configuration File (ClassPathXmlApplicationContext) 
 * 
 * @author Ben_c
 *
 */
public class SimpleSpringAppl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("simpleBeans.xml");
	
	/**
	 * Main Program for SimpleSpringAppl
	 * @param args
	 */
	public static void main(String[] args){
		
		TestingSpringBeanA testingSpringBeanA = (TestingSpringBeanA) context.getBean("testingSpringBeanA");
		System.out.println(testingSpringBeanA.getName());
	}
}
