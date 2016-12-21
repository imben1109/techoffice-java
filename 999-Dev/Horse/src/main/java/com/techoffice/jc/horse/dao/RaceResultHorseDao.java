package com.techoffice.jc.horse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceResultHorse;

@Repository
public class RaceResultHorseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addList(List<RaceResultHorse> list){
		Session session = sessionFactory.getCurrentSession();
		for (RaceResultHorse raceResultHorse: list){
			session.persist(raceResultHorse);
		}
	}
}
