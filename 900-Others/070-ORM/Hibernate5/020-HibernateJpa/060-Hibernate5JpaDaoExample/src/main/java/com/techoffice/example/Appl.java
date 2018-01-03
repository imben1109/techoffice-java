package com.techoffice.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.techoffice.example.dao.StudentDao;
import com.techoffice.example.model.Student;

public class Appl {
	
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "techoffice.example" );
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args){

		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		student.setStudentName("Test 1");
		studentDao.save(student);
		List<Student> results = studentDao.list();
		for (Student result: results){
			System.out.println(result.getStudentName());
		}
		entityManagerFactory.close();	
		
	}
}
