package com.techoffice.example.spring.appl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techoffice.example.spring.bean.TestingSpringBeanA;
import com.techoffice.example.spring.bean.TestingSpringBeanB;

/**
 * A Simple Spring Example With the Configuration is in Java Based.
 * 
 * @author Ben_c
 *
 */
@Configuration
public class SimpleSpringApplJavaBasedConfig {
	
	static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	
	@Bean
	public TestingSpringBeanA testingSpringBeanA(){
		TestingSpringBeanA testingSpringBeanA = new TestingSpringBeanA();
		testingSpringBeanA.setName("Hello World");
		return testingSpringBeanA;
	}
	
	@Bean
	public TestingSpringBeanB testingSpringBeanB(){
		TestingSpringBeanB testingSpringBeanB = new TestingSpringBeanB();	
		return testingSpringBeanB;
	}
	
	public static void main(String[] args){
		ctx.register(SimpleSpringApplJavaBasedConfig.class);
		ctx.refresh();
		TestingSpringBeanB testingSpringBeanB = ctx.getBean(TestingSpringBeanB.class);
		System.out.println(testingSpringBeanB.getTestingSpringBeanA().getName());
	}
}
