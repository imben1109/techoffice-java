package com.techoffice;

public class ConcreteClass extends TemplateClass{

	@Override
	public void method1() {
		System.out.println("Method 1 from Concrete Class");
	}
	
	public static void main(String[] args){
		ConcreteClass concreteClass = new ConcreteClass();
		concreteClass.execute();
	}
	
}
