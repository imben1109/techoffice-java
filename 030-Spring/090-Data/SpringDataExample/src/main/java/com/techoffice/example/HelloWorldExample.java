package com.techoffice.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;

/**
 * 
 * A Simple Spring Inversion of Control Simple through XML Configuration File (ClassPathXmlApplicationContext) 
 * 
 * @author Ben_c
 *
 */
@Component
public class HelloWorldExample {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void run(){
		System.out.println(customerRepository.count());
		Customer customer = new Customer("Testing 1", "Testing 1");
		customerRepository.save(customer);
		System.out.println(customerRepository.count());
		
	}
	
	/**
	 * Main Program 
	 * @param args
	 */
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorldExample helloWorldExample = context.getBean(HelloWorldExample.class);
		helloWorldExample.run();
	}
}
