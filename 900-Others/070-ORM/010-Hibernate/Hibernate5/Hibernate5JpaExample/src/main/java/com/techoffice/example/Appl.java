package com.techoffice.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.techoffice.example.model.Student;

public class Appl {
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "techoffice.example" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{
			entityManager.getTransaction().begin();
			Student student = new Student();
			student.setStudentName("Test 1");
			
			entityManager.persist(student);
			
			// HQL
			List<Student> results = entityManager.createQuery("From Student", Student.class).getResultList();
			for (Student result: results){
				System.out.println(result.getStudentName());
			}
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
