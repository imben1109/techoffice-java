package com.techoffice.example.spring.appl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techoffice.example.spring.bean.TestingSpringBeanB;

/**
 * A Simple Spring Example demonstrating annotation, "@autowired".
 * 
 * The annotation configuration is enabled through the tag <context:annotation-config/>
 * 
 * @author Ben_c
 *
 */
public class SimpleSpringApplWithAnnotation {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("simpleBeansWithAnnotation.xml");
	
	/**
	 * Main Program for SimpleSpringApplWithAnnotation
	 * @param args
	 */
	public static void main(String[] args){
		TestingSpringBeanB testingSpringBeanB = (TestingSpringBeanB) context.getBean("testingSpringBeanB");
		System.out.println(testingSpringBeanB.getTestingSpringBeanA().getName());
	}
}
