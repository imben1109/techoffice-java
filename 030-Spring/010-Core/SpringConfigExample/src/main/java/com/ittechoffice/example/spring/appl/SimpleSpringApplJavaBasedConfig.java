package com.ittechoffice.example.spring.appl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ittechoffice.example.spring.bean.TestingSpringBeanA;
import com.ittechoffice.example.spring.bean.TestingSpringBeanB;

/**
 * A Simple Spring Example With the Configuration is in Java Based.
 * 
 * @author Ben_c
 *
 */
@Configuration
public class SimpleSpringApplJavaBasedConfig {
	
	@Bean
	public TestingSpringBeanA testingSpringBeanA(){
		return new TestingSpringBeanA();
	}
	
	@Bean
	public TestingSpringBeanB testingSpringBeanB(){
		TestingSpringBeanB testingSpringBeanB = new TestingSpringBeanB();	
		return testingSpringBeanB;
	}
	
	public static void main(String[] args){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(SimpleSpringApplJavaBasedConfig.class);
		ctx.refresh();
		TestingSpringBeanB testingSpringBeanB = ctx.getBean(TestingSpringBeanB.class);
		System.out.println(testingSpringBeanB.getTestingSpringBeanA().getName());
	}
}
