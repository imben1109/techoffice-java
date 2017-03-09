package com.techoffice.jc.horse.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DrawAccelerateTimeDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Map<String, Double> getDrawAccelerateTime(String venue, String course, String distance){
		Query query = em.createNativeQuery("SELECT DRAW, ACCELERATE_TIME FROM DRAW_ACCERATE_TIME WHERE DISTANCE = :DISTANCE AND VENUE = :VENUE AND COURSE = :COURSE");
		query.setParameter("DISTANCE", distance);
		query.setParameter("COURSE", course);
		query.setParameter("VENUE", venue);
		List<Object[]> results = query.getResultList();
		Map<String, Double> map = new HashMap<String, Double>();
		for (Object[]  result : results){
			String draw = result[0].toString();
			Double d = Double.parseDouble(result[1].toString());
			map.put(draw, d);
		}
		return map;
	}
}
