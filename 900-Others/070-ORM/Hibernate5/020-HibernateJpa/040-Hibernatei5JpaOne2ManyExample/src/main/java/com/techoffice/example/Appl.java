package com.techoffice.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.techoffice.example.model.School;
import com.techoffice.example.model.Student;

public class Appl {
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "techoffice.example" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{
			entityManager.getTransaction().begin();
			Student student1 = new Student();
			student1.setStudentName("Test 1");
			Student student2 = new Student();
			student2.setStudentName("Test 1");
			
			List<Student> students = new ArrayList<Student>();
			students.add(student1);
			students.add(student2);
			
			School school = new School();
			school.setName("School 1");
			school.setStudents(students);
			entityManager.persist(school);
			
			// 
			List<Student> results = entityManager.createQuery("From Student", Student.class).getResultList();
			for (Student result: results){
				System.out.println(result.toString());
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
