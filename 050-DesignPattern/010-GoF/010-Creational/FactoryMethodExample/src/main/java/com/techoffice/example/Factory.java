package com.techoffice.example;

public class Factory extends AbstractFactory{

	@Override
	protected Student create() {
		Student student = new Student();
		student.setName("Testing");
		return student;
	}

}
