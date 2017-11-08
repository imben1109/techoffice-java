package com.ittechoffice.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans.xml")
public class SimpleSpringServiceTest {
	
	@Autowired
	private SimpleSpringService simpleSpringService;
	
	@Test
	public void test(){
		System.out.println(simpleSpringService.test());
	}
}
