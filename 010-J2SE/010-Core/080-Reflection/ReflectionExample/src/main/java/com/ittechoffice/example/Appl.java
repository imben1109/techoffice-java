package com.ittechoffice.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Appl {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Test test = new Test();
		test.setName("Testing");
		
		Method[] methods = Test.class.getMethods();
		for (int i=0; i<methods.length; i++){
			Method method = methods[i];
			System.out.format("Method of Test: %-10s Return Type: %-10s \r\n", method.getName(), method.getReturnType().getName());
			if (method.getName().equals("getName")){
				String name = (String) method.invoke(test);
				System.out.println("Value of getName(): " + name);
			}
		}
	}
}
