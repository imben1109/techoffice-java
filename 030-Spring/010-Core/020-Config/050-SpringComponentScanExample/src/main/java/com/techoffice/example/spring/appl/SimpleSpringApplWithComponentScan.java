package com.techoffice.example.spring.appl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.techoffice.example.spring.bean.TestingSpringComponentBeanA;

/**
 * A Simple Spring Example of Auto-scan.
 * 
 * The bean definition is declared in the Java Class with annotation @Component.
 * 
 * The auto-scan is enabled through the tag context:component-scan with base-package.
 * 
 * @author Ben_c
 *
 */
public class SimpleSpringApplWithComponentScan {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("simpleBeansWithComponentScan.xml");
	
	public static void main(String[] args){
		TestingSpringComponentBeanA testingSpringComponentBeanA = (TestingSpringComponentBeanA)context.getBean("testingSpringComponentBeanA");
    	System.out.println(testingSpringComponentBeanA.getName());
	}
}
