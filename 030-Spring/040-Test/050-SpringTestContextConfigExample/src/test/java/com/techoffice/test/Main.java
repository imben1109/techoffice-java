package com.techoffice.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.techoffice.TestBeanA;
import com.techoffice.test.config.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		loader=AnnotationConfigContextLoader.class,
		classes=Config.class
)
public class Main {
	
	@Autowired
	private TestBeanA testBeanA;
	
	@Test
	public void test(){
		System.out.println(testBeanA.getName());
	}
	
}
