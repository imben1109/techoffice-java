package com.techoffice.example;

public class Appl {
	
	public Appl(){}
	
	public void run2(String abc){
		System.out.println("run2");
	}
	
	public void run(String abc){
		System.out.println("run");
		run2(abc);
	}
	

}
