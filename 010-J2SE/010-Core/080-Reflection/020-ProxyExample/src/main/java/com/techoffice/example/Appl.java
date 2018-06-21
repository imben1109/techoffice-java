package com.techoffice.example;

import java.lang.reflect.Proxy;

public class Appl {

	public static void main(String[] args){
		TestService test = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(), new Class[]{TestService.class}, new ExampleInvcationHandler());
		System.out.println(test.getName() + " " + test.getAge());
	}
}
