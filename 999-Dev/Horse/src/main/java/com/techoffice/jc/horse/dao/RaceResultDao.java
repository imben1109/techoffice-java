package com.techoffice.jc.horse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceResult;

@Repository
public class RaceResultDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void add(RaceResult raceResult){
		Session session = sessionFactory.getCurrentSession();
		session.persist(raceResult);
	}
}
