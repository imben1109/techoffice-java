package com.techoffice.example;

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
		Student student1 = studentDao.get(1);

		System.out.println(student1.toString());

		student1.setStudentName(student1.getStudentName() + "+");
		
		studentDao.update(student1);
		System.out.println(student1.toString());

		entityManagerFactory.close();	
		
	}
}
