package com.techoffice.example;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.example.dao.StudentDao;
import com.techoffice.example.model.Student;

@Component
public class Appl {
	
	@Autowired
	private StudentDao studentDao;
	
	@Transactional
	public void run(){
		Student student = new Student();
		student.setName("Test 1");
		studentDao.persist(student);
		List<Student> results = studentDao.findAll();
		System.out.println("Total Student: " + results.size());
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
