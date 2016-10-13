package com.ittechoffice.example.spring.appl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ittechoffice.example.spring.bean.TestingSpringComponentBeanA;

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
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("simpleBeansWithComponentScan.xml");
		TestingSpringComponentBeanA testingSpringComponentBeanA = (TestingSpringComponentBeanA)context.getBean("testingSpringComponentBeanA");
    	System.out.println(testingSpringComponentBeanA.getName());
	}
}
