package com.techoffice.example;

import com.techoffice.example.factory.ConcreteFactory1;
import com.techoffice.example.factory.ConcreteFactory2;
import com.techoffice.example.factory.intf.Factory;

/**
 * Abstract Factory Design Pattern make it possible to change the implementation without changing the code that use them. 
 * @author Ben_c
 *
 */
public class Appl {
	public static void main(String[] args){
		Factory factory;
		
		factory = new ConcreteFactory1();
		Student student1 = factory.createStudent();
		System.out.println(student1.getName());
		
		factory = new ConcreteFactory2();
		Student student2 = factory.createStudent();
		System.out.println(student2.getName());
	}
}
