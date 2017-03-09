package com.techoffice.example;

public class Appl {
	public static void main(String[] args){
		AbstractFactory factory = new Factory();
		Student student = factory.create();
		System.out.println(student.getName());
	}
}
