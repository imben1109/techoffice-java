package com.techoffice.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.techoffice.example.model.Student;

public class Appl {
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("techoffice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try{
			// Open Transaction
			entityManager.getTransaction().begin();

			// Prepare data for Student Table
			Student student = new Student();
			student.setStudentName("Test 1");
			
			entityManager.persist(student);
			
			// Retrieve Data from Student Table by Named Query
			System.out.println("Retrieve by Named Query");
			System.out.println("========================");
			List<Student> namedQueryResults = entityManager.createNamedQuery("Student.getStudent", Student.class).getResultList();
			for (Student result: namedQueryResults){
				System.out.println(result.getStudentName());
			}
			System.out.println("");
			System.out.println("Retrieve by Named Native Query");
			System.out.println("========================");
			List<Student> namedNativeQueryResults = entityManager.createNamedQuery("Student.getStudentNativeQuery", Student.class).getResultList();
			for (Student result: namedNativeQueryResults){
				System.out.println(result.getStudentName());
			}
			
			// Close Transaction
			entityManager.getTransaction().commit();
			
			entityManager.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// close the factory and release any resource it holds.
			entityManagerFactory.close();
		}

	}
}
