package com.techoffice.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.techoffice.TestBean;
import com.techoffice.TestBeanA;

@ImportResource({"classpath:/test-beans.xml"})
@Configuration
public class Config {

	@Autowired
	private TestBean testBean;
	
	@Bean
	public TestBeanA testBeanA(){
		TestBeanA testBeanA = new TestBeanA();
		testBeanA.setName(testBean.getName());
		return testBeanA;
	}
}
