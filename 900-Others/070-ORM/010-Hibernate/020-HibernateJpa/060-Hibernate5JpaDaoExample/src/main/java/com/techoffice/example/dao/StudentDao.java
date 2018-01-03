package com.techoffice.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.techoffice.example.Appl;
import com.techoffice.example.model.Student;

public class StudentDao {
	 private EntityManager entityManager = Appl.entityManager;
	 
	 public List<Student> list(){
		 List<Student> results = entityManager.createQuery("From Student", Student.class).getResultList();
		 return results;
	 }
	 
	 public Student save(Student student){
		 entityManager.getTransaction().begin();
		 entityManager.persist(student);
		 entityManager.getTransaction().commit();;
		 return student;
	 }
	 
	 public void delete(Student student){
//		 entityManager.
	 }
	 
}
