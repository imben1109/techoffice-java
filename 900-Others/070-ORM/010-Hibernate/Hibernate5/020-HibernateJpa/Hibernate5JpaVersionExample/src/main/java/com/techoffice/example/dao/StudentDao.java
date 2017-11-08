package com.techoffice.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.techoffice.example.VersionUpdateExample;
import com.techoffice.example.model.Student;

public class StudentDao {
	 private EntityManager entityManager = VersionUpdateExample.entityManager;
	 
	 public List<Student> list(){
		 List<Student> results = entityManager.createQuery("From Student", Student.class).getResultList();
		 return results;
	 }
	 
	 public Student get(int id){
		 Student student = entityManager.find(Student.class, 1);
		 entityManager.detach(student);
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
		 student = entityManager.merge(student);
		 entityManager.getTransaction().commit();
		 entityManager.detach(student);
		 return student;
	 }
	 
	 public void delete(Student student){
//		 entityManager.
	 }
	 
}
