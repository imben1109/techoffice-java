package com.techoffice.jc.horse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceDate;

@Repository
public class RaceDateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void add(RaceDate raceDate){
		Session session = sessionFactory.getCurrentSession();
		session.persist(raceDate);
	}
	
	@Transactional
	public void update(RaceDate raceDate){
		Session session = sessionFactory.getCurrentSession();
		session.update(raceDate);
	}
	
	@Transactional
	public List<RaceDate> list(){
		Session session = sessionFactory.getCurrentSession();
		Query<RaceDate> query = session.createQuery("From RaceDate", RaceDate.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<RaceDate> getPendingRaceDateList(){
		Session session = sessionFactory.getCurrentSession();
		Query<RaceDate> query = session.createQuery("From RaceDate where raceCount < 2 and raceType != 'Simulcast' ", RaceDate.class);
		return query.getResultList();
	}
	
	
	
	@Transactional
	public RaceDate getByRaceDate(String raceDate){
		Session session = sessionFactory.getCurrentSession();
		Query<RaceDate> query = session.createQuery("from RaceDate where raceDate = :RACEDATE", RaceDate.class);
		query.setParameter("RACEDATE", raceDate);
		List<RaceDate> list = query.getResultList();
		if (list.size() == 1){
			return list.get(0);
		}	
		return null;
	}
}
