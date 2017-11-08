package com.techoffice.example;

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
	
	// INSERT INTO STUDENT
	// COMMIT
	// SELECT STUDENT FROM STUDENT 
	// UPDATE STUDENT
	public void run(){
		Student student = new Student();
		student.setName("Test 1");
		
		// It would persist the entity. 
		// As this method is without a transaction, It would commit the transaction 
		// which make the entity detached.
		studentDao.update(student);
		System.out.println(student.getId());
		
		// The student entity is detached. Therefore, it could not be persisted in the entity managed.
		// The Solution is make the entity managed which merge the entity. It shows in the the method, run2
		try{
			student.setDesc("TEST 1");
			studentDao.update(student);
		}catch(Exception e){
			System.out.println("Exception Message: " + e.getMessage());
		}
	}
	
	// Select student form Student
	// Update Student
	public void run2(){
		Student student = new Student();
		student.setId(1);
		student.setName("Test 2");
		student.setDesc("TEST2");
		studentDao.update2(student);
	}
	
	// SELECT STUDENT FROM STUDENT
	// UPDATE STUDENT
	// COMMIT
	@Transactional
	public void run3(){
		Student student = new Student();
		student.setId(1);
		student.setName("Test 3");
		student.setDesc("TEST3");
		studentDao.update2(student);
		student.setDesc("TEST4");
		studentDao.update2(student);
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Appl appl = context.getBean(Appl.class);
		appl.run();
		appl.run2();
		appl.run3();

	}
}
