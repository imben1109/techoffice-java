package com.techoffice.example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.techoffice.example.model.Student1;
import com.techoffice.example.model.Student2;

public class Appl {
	public static void main(String[] args) throws IOException, IllegalAccessException, InvocationTargetException {
		
		// Prepare a bean
		Student1 student1 = new Student1();
		student1.setName("Test01");
		student1.setAge(20);
		student1.setDate("2016-12-30");
		
		// a empty bean of another class 
		Student2 student2 = new Student2();
		
		DateConverter dateConverter = new DateConverter();
		dateConverter.setPattern("yyyy-MM-dd");
		ConvertUtils.register(dateConverter, java.util.Date.class);

		BeanUtils.copyProperties(student2, student1);
		System.out.println(student2.getName() + " " + student2.getAge() + " " + student2.getDate());
	}
}
