package com.techoffice.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techoffice.example.bean.HelloWorldExample;

public class Appl {
	
	private static 	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	public static void main(String[] args){
		HelloWorldExample helloWorldExample = context.getBean(HelloWorldExample.class);
		System.out.println(helloWorldExample.getMessage());
	}
	
}
