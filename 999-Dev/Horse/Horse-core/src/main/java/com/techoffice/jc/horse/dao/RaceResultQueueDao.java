package com.techoffice.jc.horse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceResultQueue;

@Repository
public class RaceResultQueueDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addRaceResultQueueList(List<RaceResultQueue> list){
		for(RaceResultQueue raceResultQueue: list){
			em.persist(raceResultQueue);
		}
	}
	
	@Transactional
	public void addRaceResultQueue(RaceResultQueue raceResultQueue){
		em.persist(raceResultQueue);
	}
	
	@Transactional
	public RaceResultQueue getRaceResultQueueByLocation(String location){
		TypedQuery<RaceResultQueue> query = em.createQuery("From RaceResultQueue where lower(LOCATION) = lower(:LOCATION) ", RaceResultQueue.class);
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
		em.createQuery("DELETE From RaceResultQueue").executeUpdate();
	}
	
	@Transactional
	public List<RaceResultQueue> list(){
		TypedQuery<RaceResultQueue> query = em.createQuery("from RaceResultQueue", RaceResultQueue.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<RaceResultQueue> listActiveQueue(){
		TypedQuery<RaceResultQueue> query = em.createQuery("from RaceResultQueue where isnull(runInd, '') <> 'Y'", RaceResultQueue.class);
		return query.getResultList();
	}
	
	@Transactional
	public void update(RaceResultQueue raceResultQueue){
		em.persist(raceResultQueue);
	}
	
	@Transactional
	public RaceResultQueue get(int id){
		TypedQuery<RaceResultQueue> query = em.createQuery("From RaceResultQueue Where id = :id", RaceResultQueue.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<RaceResultQueue> query(){

		return null;
	}
	
}
