package com.techoffice.example;

/**
 * Builder design pattern is a solution to a problem of "too many constructor"
 * 
 * @author Ben_c
 * 
 */
public class Appl {
	public static void main(String[] args){
		StudentBuilder builder = new StudentBuilder();
		builder.setName("Testing Batch 1 ");
		builder.setSex("M");
		Student student = builder.build();
		System.out.println(student.getName());
	}
}
