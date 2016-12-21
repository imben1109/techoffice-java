package com.techoffice.jc.horse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceResultQueue;

@Repository
public class RaceResultQueueDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addRaceResultQueueList(List<RaceResultQueue> list){
		Session session = sessionFactory.getCurrentSession();
		for(RaceResultQueue raceResultQueue: list){
			session.persist(raceResultQueue);
		}
	}
	
	@Transactional
	public void addRaceResultQueue(RaceResultQueue raceResultQueue){
		Session session = sessionFactory.getCurrentSession();
		session.persist(raceResultQueue);
	}
	
	@Transactional
	public void deleteAll(){
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE From RaceResultQueue").executeUpdate();
	}
}
