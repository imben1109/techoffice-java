package com.techoffice.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return em.createQuery("SELECT s FROM Student s").getResultList();
	}


}
