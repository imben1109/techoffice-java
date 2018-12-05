package com.techoffice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techoffice.bean.TestBean1;
import com.techoffice.bean.TestBean2;

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
public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args){
		TestBean1 testBean1 = context.getBean(TestBean1.class);
    	System.out.println(testBean1.getName());
    	
		TestBean2 testBean2 = context.getBean(TestBean2.class);
    	System.out.println(testBean1.getName());
    	
	}
}
