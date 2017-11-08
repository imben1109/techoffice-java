package com.techoffice.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * A Simple Spring Inversion of Control Simple through XML Configuration File (ClassPathXmlApplicationContext) 
 * 
 * @author Ben_c
 *
 */
@Component
public class Appl {
		
	public void run(){
		System.out.println("Tech Office Example");
	}
	
	/**
	 * Main Program 
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Appl appl = context.getBean(Appl.class);
		appl.run();

	}
}
