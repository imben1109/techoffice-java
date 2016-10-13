package com.ittechoffice.example.junitexample;

import org.junit.Assert;
import org.junit.Test;

public class JunitExampleTest {
	
	@Test
	public void getOneTest(){
		JunitExample junitExample = new JunitExample ();
		int result = junitExample.getOne();
		Assert.assertEquals(1, result);
	}
	
}
