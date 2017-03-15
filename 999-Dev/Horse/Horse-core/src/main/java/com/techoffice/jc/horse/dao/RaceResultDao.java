package com.techoffice.jc.horse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceResult;

@Repository
public class RaceResultDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void update(RaceResult raceResult){
		em.persist(raceResult);
	}
	
	@Transactional
	public List<RaceResult> list(){
		TypedQuery<RaceResult> query = em.createQuery("From RaceResult", RaceResult.class);
		return query.getResultList();
	}

	@Transactional
	public List<String> listVenue(){
		List<String> resultList = new ArrayList<String>();
		Query query = em.createNativeQuery("SELECT DISTINCT VENUE FROM RACE_RESULT");
		List<String> queryResultList= query.getResultList();
		for (String queryResult: queryResultList){
			resultList.add(queryResult);
		}
		return resultList;
	}
}
