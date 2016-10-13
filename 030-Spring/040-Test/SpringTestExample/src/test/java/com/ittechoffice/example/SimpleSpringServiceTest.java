package com.ittechoffice.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
		String result = simpleSpringService.test();
		Assert.assertEquals(result, "Test");
	}
}
