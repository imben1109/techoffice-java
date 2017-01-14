package com.techoffice.jc.horse.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DrawAccelerateTimeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Map<String, Double> getDrawAccelerateTime(String venue, String course, String distance){
		Session session = sessionFactory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("SELECT DRAW, ACCELERATE_TIME FROM DRAW_ACCERATE_TIME WHERE DISTANCE = :DISTANCE AND VENUE = :VENUE AND COURSE = :COURSE");
		query.setParameter("DISTANCE", distance);
		query.setParameter("COURSE", course);
		query.setParameter("VENUE", venue);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> results = query.getResultList();
		Map<String, Double> map = new HashMap<String, Double>();
		for (Map<String,Object>  result : results){
			String draw = result.get("DRAW").toString();
			Double d = Double.parseDouble(result.get("ACCELERATE_TIME").toString());
			map.put(draw, d);
		}
		return map;
	}
}
