package com.techoffice.example;

import com.techoffice.example.decorator.WordHardPersonDecorator;
import com.techoffice.example.impl.WorkHardPerson;
import com.techoffice.example.intf.Study;

public class Appl {
	public static void main(String[] args){
		Study person = new WorkHardPerson();
		person.study();
		
		System.out.println("\n===After Decorating===");
		
		WordHardPersonDecorator wordHardPersonDecorator = new WordHardPersonDecorator(person);
		wordHardPersonDecorator.study();
	}
}
