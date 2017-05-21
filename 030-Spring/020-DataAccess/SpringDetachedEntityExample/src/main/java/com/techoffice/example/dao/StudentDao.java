package com.techoffice.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.example.model.Student;

@Repository
public class StudentDao {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void update(Student student) {
		em.persist(student);
	}
	
	@Transactional
	public void update2(Student student) {
		if (student.getId() > 0){
			student = em.merge(student);
		}else{
			em.persist(student);
		}
	}
	
	public List<Student> findAll() {
		Query query =  em.createQuery("SELECT s FROM Student s");
		query.setMaxResults(10);
		query.setFirstResult(1);
		List<Student> results = query.getResultList();
		return results;
	}


}
