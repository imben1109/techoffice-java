package com.techoffice.example.factory;

import com.techoffice.example.Student;
import com.techoffice.example.factory.intf.Factory;

public class ConcreteFactory1 implements Factory{

	public Student createStudent() {
		Student student = new Student();
		student.setName("created by factory 1");
		return student;
	}

}
