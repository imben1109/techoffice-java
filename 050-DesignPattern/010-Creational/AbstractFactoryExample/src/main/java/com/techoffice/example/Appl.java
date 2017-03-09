package com.techoffice.example;

import com.techoffice.example.factory.ChineseFactory;
import com.techoffice.example.factory.AmericanFactory;
import com.techoffice.example.factory.intf.Factory;
import com.techoffice.example.model.Person;

/**
 * Abstract Factory 
 * 
 * creating family of object with out specifyin their concrete classes.
 * 
 * @author Ben_c
 *
 */
public class Appl {
	public static void main(String[] args){
		Factory factory;
		
		factory = new ChineseFactory();
		Person person1 = factory.createPerson();
		System.out.println(person1.getName());
		
		factory = new AmericanFactory();
		Person person2 = factory.createPerson();
		System.out.println(person2.getName());
	}
}
