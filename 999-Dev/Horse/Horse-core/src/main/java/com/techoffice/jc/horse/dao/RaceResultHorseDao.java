package com.techoffice.jc.horse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	
	@Transactional
	public List<String> getHorseNameList(){
		TypedQuery<String> query = em.createQuery("SELECT DISTINCT horseName FROM RaceResultHorse", 
				String.class);
		return query.getResultList();
	}
	
	/**
	 * List By Large Distance 
	 * 
	 * Large Distance means the distance more than or equal to 2 horse distance.
	 * 
	 * @return List of Race Result Horse
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RaceResultHorse> listByLargeDistance(){
		Query query = em.createNativeQuery("select * from RACE_RESULT_HORSE where place = '1' and race_result_id in (select race_result_id from RACE_RESULT_HORSE where place = '2' and lbw not in ('N', 'SH', 'NOSE', 'HD', '1', '1/2', '3/4', '1-1/2', '1-1/4', '1-3/4'))", 
				RaceResultHorse.class);
		return query.getResultList();
	}
	
	public List<RaceResultHorse> listByPlaceOne(){
		TypedQuery<RaceResultHorse> query = em.createQuery("From RaceResultHorse Where place = '1' order by raceResult.raceDate desc", RaceResultHorse.class);
		return query.getResultList();
	}
	
	public List<RaceResultHorse> listByPlaceOneTwoThree(){
		TypedQuery<RaceResultHorse> query = em.createQuery("From RaceResultHorse Where place in ('1', '2', '3') order by raceResult.raceDate desc", RaceResultHorse.class);
		return query.getResultList();
	}
}
