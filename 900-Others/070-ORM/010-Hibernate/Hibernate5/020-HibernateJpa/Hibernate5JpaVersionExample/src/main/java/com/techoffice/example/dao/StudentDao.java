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
	 
	 public Student get(int id){
		 Student student = entityManager.find(Student.class, 1);
		 return student;
	 }
	 
	 public Student create(Student student){
		 entityManager.getTransaction().begin();
		 entityManager.persist(student);
		 entityManager.getTransaction().commit();;
		 return student;
	 }
	 
	 public Student update(Student student){
		 entityManager.getTransaction().begin();
		 entityManager.merge(student);
		 entityManager.getTransaction().commit();
		 return student;
	 }
	 
	 public void delete(Student student){
//		 entityManager.
	 }
	 
}
