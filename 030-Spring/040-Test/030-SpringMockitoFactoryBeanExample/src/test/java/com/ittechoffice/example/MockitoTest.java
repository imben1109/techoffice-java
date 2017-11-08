package com.ittechoffice.example;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoTest {
	
	@Test
	public void test(){
		SimpleSpringService simpleSpringService =Mockito.mock(SimpleSpringService.class);
		Mockito.when(simpleSpringService.test()).thenReturn("From Mockito");
		System.out.println(simpleSpringService.test());
	}
}
