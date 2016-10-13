package com.ittechoffice.example.appl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * EntityManagerFactory
 * 
 * It is in J2EE. 
 * 
 * It interacts with the entity manager factory for the persistence unit
 * 
 * It requires to create persistence.xml in src/main/resources/META-INF/persistence.xml
 * 
 */

public class EntityFactoryExample {
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
