package com.techoffice.jc.horse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceDate;

@Repository
public class RaceDateDao {
	
	@PersistenceContext
	private EntityManager em;
		
	@Transactional
	public void update(RaceDate raceDate){
		em.persist(raceDate);
	}
	
	@Transactional
	public List<RaceDate> list(){
		TypedQuery<RaceDate> query = em.createQuery("Select r from RaceDate r", RaceDate.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<RaceDate> getPendingRaceDateList(){
		TypedQuery<RaceDate> query = em.createQuery("From RaceDate where raceCount < 2 and raceType != 'Simulcast' ", RaceDate.class);
		return query.getResultList();
	}
	
	@Transactional
	public RaceDate getByRaceDate(String raceDate){
		TypedQuery<RaceDate> query = em.createQuery("from RaceDate where raceDate = :RACEDATE", RaceDate.class);
		query.setParameter("RACEDATE", raceDate);
		List<RaceDate> list = query.getResultList();
		if (list.size() == 1){
			return list.get(0);
		}	
		return null;
	}
}
