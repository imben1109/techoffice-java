package com.techoffice.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.techoffice.example.dao.StudentDao;
import com.techoffice.example.model.Student;

/**
 * This Example demonstrates how to increment the version number
 * 
 * @author imben1109
 *
 */
public class VersionUpdateExample {
	
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "techoffice.example" );
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args){
		
		StudentDao studentDao = new StudentDao();
		Student student1 = studentDao.get(1);

		System.out.println(student1.toString());

		student1.setStudentName(student1.getStudentName() + "+");
		
		student1 = studentDao.update(student1);
		System.out.println(student1.toString());

		entityManagerFactory.close();	
		
	}
}
