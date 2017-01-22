package com.techoffice.jc.horse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;
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
	public RaceResultQueue getRaceResultQueueByLocation(String location){
		Session session = sessionFactory.getCurrentSession();
		Query<RaceResultQueue> query = session.createQuery("From RaceResultQueue where lower(LOCATION) = lower(:LOCATION) ", RaceResultQueue.class);
		query.setParameter("LOCATION", location);
		List<RaceResultQueue> resultQueueList = query.getResultList();
		if (resultQueueList.size() == 0 ){
			return null;
		}else if (resultQueueList.size() == 1){
			return resultQueueList.get(0);
		}
		return null;
	}
	
	@Transactional
	public void deleteAll(){
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE From RaceResultQueue").executeUpdate();
	}
	
	@Transactional
	public List<RaceResultQueue> list(){
		Session session = sessionFactory.getCurrentSession();
		Query<RaceResultQueue> query = session.createQuery("from RaceResultQueue", RaceResultQueue.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<RaceResultQueue> listActiveQueue(){
		Session session = sessionFactory.getCurrentSession();
		Query<RaceResultQueue> query = session.createQuery("from RaceResultQueue where isnull(runInd, '') <> 'Y'", RaceResultQueue.class);
		return query.getResultList();
	}
	
	@Transactional
	public void update(RaceResultQueue raceResultQueue){
		Session session = sessionFactory.getCurrentSession();
		session.update(raceResultQueue);
	}
}
