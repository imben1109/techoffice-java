package com.techoffice.example;

public class Example1 {
	
	public static void main(String[] args) throws ClassNotFoundException{
		ClassLoader classLoader = Example1.class.getClassLoader();
        Class<?> Example2 = classLoader.loadClass("com.techoffice.example.Example2");
        
	}
	
}
