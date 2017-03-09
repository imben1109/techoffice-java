package com.techoffice.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.techoffice.example.model.Student;

@Repository
public class StudentDao {
	
	@PersistenceContext
	private EntityManager em;

	public void persist(Student student) {
		em.persist(student);
	}
	
	public List<Student> findAll() {
		
		Query query =  em.createQuery("SELECT s FROM Student s");
		query.setMaxResults(10);
		query.setFirstResult(1);
		List<Student> results = query.getResultList();
		return results;
	}


}
