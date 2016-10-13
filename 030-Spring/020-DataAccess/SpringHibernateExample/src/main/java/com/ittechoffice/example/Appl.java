package com.ittechoffice.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ittechoffice.example.model.Student;

@Component
public class Appl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void run(){
		Session session = sessionFactory.getCurrentSession();
		Student student = new Student();
		student.setName("Test 1");
		int id = (Integer) session.save(student);
		System.out.println("student with id=" + id + " is created");
		List<Student> results = session.createQuery("From Student").list();
		System.out.println("Total Student: " + results.size());
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
