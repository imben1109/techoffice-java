package com.techoffice.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Appl {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	public void run(){
		System.out.println("Spring Quartz Example");
	}
	
	public static void main(String[] args){
		Appl appl = context.getBean(Appl.class);
		appl.run();
		
	}
}
