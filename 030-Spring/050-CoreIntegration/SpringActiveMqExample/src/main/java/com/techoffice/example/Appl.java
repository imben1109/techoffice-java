package com.techoffice.example;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Appl {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	public void run(){

	}
	
	public static void main(String[] args) throws Exception{

//		Appl appl = context.getBean(Appl.class);
//		appl.run();
	}
}
