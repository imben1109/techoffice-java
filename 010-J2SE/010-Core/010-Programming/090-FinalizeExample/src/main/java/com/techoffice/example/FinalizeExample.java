package com.techoffice.example;

/**
 * 
 */
public class FinalizeExample {
	
	public void doSomething(){
		System.out.println("Do Something");
	}
	
	@Override
	public void finalize(){
		System.out.println("Destroying");
	}
	
	public static void main(String... args){
		FinalizeExample finalizeExample = new FinalizeExample();
		finalizeExample.doSomething();
		finalizeExample = null;
		Runtime.getRuntime().gc();
	}
}
