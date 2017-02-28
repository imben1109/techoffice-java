package com.techoffice.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Appl {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void run(){
		Query query ;
		query = em.createNativeQuery("insert into student values (1, 'Test Student', 'Test Desc')");
		query.executeUpdate();
		query = em.createNativeQuery("select id, name, desc from student");
		List<Object[]> results = query.getResultList();
		for (Object[] result: results){
			System.out.println(result[0].toString() + " " + result[1].toString() + " " + result[2].toString());
		}
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
