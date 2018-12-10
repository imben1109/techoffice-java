package com.techoffice.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");


	public static void main(String[] args) {
		Tester tester = context.getBean(Tester.class);
		tester.test();
	}
}
