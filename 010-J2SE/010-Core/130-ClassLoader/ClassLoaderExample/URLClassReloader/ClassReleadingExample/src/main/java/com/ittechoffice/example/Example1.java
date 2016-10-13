package com.ittechoffice.example;

public class Example1 {
	
	public void sayHi(){
		System.out.println("Hi, this is Example1 from ClassLoaderClassesReloadingExample!");
	}
	
	public static void main(String[] args){
		Example1 example1 = new Example1();
		example1.sayHi();
	}
}
