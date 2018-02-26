package com.techoffice.example;

import java.net.URL;

public class Example1 {
	
	public static void main(String[] args){
		String className = Example1.class.getCanonicalName().replace(".", "/") + ".class";
		URL url = Example1.class.getClassLoader().getResource(className);
		if (url == null){
			System.out.println("not found class from classloader: " + className);
		}else {
			System.out.println("found class from classloader: " + className);
		}
	}
	
}
