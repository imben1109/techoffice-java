package com.techoffice.example;

/**
 * Lambda Expression is used for defining anonymous function.
 * 
 * In this example, it would define an interface which only contains a method and an anonymous function of the interface would be defined through lambda expression. 
 * 
 * @author Ben_c
 *
 */
public class LambdaExpressionsExample {
	
	interface Interface1 {
        int operation(int a, int b);   
	}
	
	public static void main(String... args){
		Interface1 interface1 = (a, b) -> a + b;
		System.out.println(interface1.operation(1, 2));
	}
}
