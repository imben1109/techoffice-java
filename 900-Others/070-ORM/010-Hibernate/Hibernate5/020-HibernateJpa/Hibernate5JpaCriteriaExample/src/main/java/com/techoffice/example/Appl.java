package com.techoffice.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techoffice.example.model.Student;

public class Appl {
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "techoffice.example" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{
			// Create Testing Data
			entityManager.getTransaction().begin();
			Student student = new Student();
			student.setStudentName("Test 1");
			entityManager.persist(student);
			
			// Criteria
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
			Root<Student> from = criteriaQuery.from(Student.class);
			criteriaQuery.where(criteriaBuilder.equal(from.get("studentName"), "Test 1"));
			List<Student> results = entityManager.createQuery(criteriaQuery).getResultList();;
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
