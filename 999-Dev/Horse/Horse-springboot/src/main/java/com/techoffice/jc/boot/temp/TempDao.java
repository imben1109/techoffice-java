package com.techoffice.jc.boot.temp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class TempDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Integer> get(){
		Query query = em.createNativeQuery("SELECT distinct(race_result_id) FROM RACE_RESULT_HORSE where jockey is null ");
		List<Integer> list = query.getResultList();
		return list;
	}
}
