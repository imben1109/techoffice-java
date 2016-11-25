package com.techoffice.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldExample {
	
	public void run(){
		System.out.println("run");
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorldExample helloWorldExample = context.getBean(HelloWorldExample.class);
		helloWorldExample.run();
	}
}
