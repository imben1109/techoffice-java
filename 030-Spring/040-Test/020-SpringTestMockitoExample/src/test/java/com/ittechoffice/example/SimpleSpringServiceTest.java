package com.ittechoffice.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans.xml")
public class SimpleSpringServiceTest {
	
	@Autowired
	private SimpleSpringService simpleSpringService;
	
	@Test
	public void test(){
		Mockito.when(simpleSpringService.test()).thenReturn("From Mockito");
		
		String result = simpleSpringService.test();
		System.out.println(simpleSpringService.test());
		Assert.assertEquals(result, "From Mockito");
	}
}
