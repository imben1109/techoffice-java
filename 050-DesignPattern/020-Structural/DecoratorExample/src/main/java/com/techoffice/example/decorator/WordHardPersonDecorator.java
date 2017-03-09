package com.techoffice.example.decorator;

import com.techoffice.example.intf.Study;

public class WordHardPersonDecorator implements Study{
	
	private Study person;

	public WordHardPersonDecorator(Study person){
		this.person = person;
	}
	
	
	public void study() {
		System.out.println("Going to Study Room.");
		person.study();
		System.out.println("Study until get a good grade in the exam");
	}
}
