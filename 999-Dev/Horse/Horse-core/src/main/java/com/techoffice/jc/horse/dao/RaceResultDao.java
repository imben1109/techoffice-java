package com.techoffice.jc.horse.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceResult;

@Repository
public class RaceResultDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void add(RaceResult raceResult){
		em.persist(raceResult);
	}
}
