package com.techoffice.jc.horse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;

@Repository
public class RaceResultHorseDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addList(List<RaceResultHorse> list){
		for (RaceResultHorse raceResultHorse: list){
			em.persist(raceResultHorse);
		}
	}
	
	@Transactional
	public void update(RaceResultHorse raceResultHorse){
		em.persist(raceResultHorse);
	}
	
	@Transactional
	public List<RaceResultHorse> list(){
		TypedQuery<RaceResultHorse> query = em.createQuery("From RaceResultHorse", RaceResultHorse.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<RaceResultHorse> listByRaceResult(RaceResult raceResult){
		TypedQuery<RaceResultHorse> query = em.createQuery("From RaceResultHorse Where raceResult = :RaceResult ", RaceResultHorse.class);
		query.setParameter("RaceResult", raceResult);
		return query.getResultList();	
	}
	
	@Transactional
	public List<RaceResultHorse> listByRaceResult(int raceResultId){
		TypedQuery<RaceResultHorse> query = em.createQuery("From RaceResultHorse Where raceResult.id = :RaceResultId", RaceResultHorse.class);
		query.setParameter("RaceResultId", raceResultId);
		return query.getResultList();	
	}
	
	@Transactional
	public List<RaceResultHorse> listByHorseName(String horseName){
		TypedQuery<RaceResultHorse> query = em.createQuery("From RaceResultHorse Where horseName = :horseName order by raceResult.raceDate desc", RaceResultHorse.class);
		query.setParameter("horseName", horseName);
		return query.getResultList();	
		
	}
}
