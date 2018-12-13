package com.techoffice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techoffice.service.TestingService1;

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
public class App {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
	
	public static void main(String[] args){
		TestingService1 testingBean1 = context.getBean(TestingService1.class);
		testingBean1.doSomething1();
	}
}
