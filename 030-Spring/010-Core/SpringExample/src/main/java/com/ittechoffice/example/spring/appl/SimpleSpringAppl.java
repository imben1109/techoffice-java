package com.ittechoffice.example.spring.appl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ittechoffice.example.spring.bean.TestingSpringBeanA;

/**
 * 
 * A Simple Spring Inversion of Control Simple through XML Configuration File (ClassPathXmlApplicationContext) 
 * 
 * @author Ben_c
 *
 */
public class SimpleSpringAppl {
	
	/**
	 * Main Program for SimpleSpringAppl
	 * @param args
	 */
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("simpleBeans.xml");
		TestingSpringBeanA testingSpringBeanA = (TestingSpringBeanA) context.getBean("testingSpringBeanA");
		System.out.println(testingSpringBeanA.getName());
	}
}
