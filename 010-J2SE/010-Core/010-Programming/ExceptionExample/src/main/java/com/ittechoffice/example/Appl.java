package com.ittechoffice.example;

public class Appl {
	
	public void run(){
		System.out.println("Hello. This is an exception example");
		try{
			System.out.println("Print before exception");
			doSomething();
			System.out.println("Print after exception");
		}catch (SimpleException simpleException){
			System.out.println("Exception Message: " + simpleException.getMessage());
			simpleException.printStackTrace(System.out);
		}
	}
	
	public void doSomething() throws SimpleException{
		throw new SimpleException("This is Simple Exception");
	}
	
	public static void main(String[] args){
		Appl appl = new Appl();
		appl.run();
	}
}
