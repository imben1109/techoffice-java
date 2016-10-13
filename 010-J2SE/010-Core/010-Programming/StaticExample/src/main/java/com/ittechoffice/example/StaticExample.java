package com.ittechoffice.example;


public class StaticExample {
	static {
		System.out.println("This is StaticExample");
	}
	
	public static void main(String[] args) throws ClassNotFoundException{
		System.out.println("Hello Main");
		// Force VM load the name named "AnotherClass"
		Class.forName("com.ittechoffice.example.AnotherClass");
	}
}
