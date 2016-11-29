package com.ittechoffice.example.hibernatejpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ittechoffice.example.hibernatejpa.model.Student;

public class Appl {
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "com.ittechoffice.example.hibernatejpa.model" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Student student = new Student();
		student.setStudentName("Test 1");
		
		entityManager.persist(student);
		
		List<Student> results = entityManager.createQuery( "from Student", Student.class ).getResultList();
		for (Student result: results){
			System.out.println(result.getStudentName());
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
