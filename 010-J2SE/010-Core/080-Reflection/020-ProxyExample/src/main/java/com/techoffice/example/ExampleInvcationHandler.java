package com.techoffice.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ExampleInvcationHandler implements InvocationHandler{

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoked " + proxy.getClass() + " "+ method.getName());
		return null;
	}

	
}
