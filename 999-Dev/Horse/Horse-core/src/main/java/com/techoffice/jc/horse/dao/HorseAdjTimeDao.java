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

import com.techoffice.jc.horse.dto.CurrentOdd;

@Repository
public class HorseAdjTimeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<CurrentOdd>  getAdjTime(List<CurrentOdd> horseList){
		String horseQuery = "(";
		for (CurrentOdd horse: horseList){
			if (!horseQuery.equals("(")){
				horseQuery += ", ";
			}
			String horseName = horse.getHorseName();
			horseName = horseName.replace("'", "''");
			horseQuery += "'" + horseName + "'";
		}
		horseQuery += ")";
		Session session = sessionFactory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("SELECT HORSE_NAME, AVG_ADJ_TIME FROM HORSE_ADJ_TIME WHERE HORSE_NAME in " + horseQuery + " ORDER BY AVG_ADJ_TIME ASC");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Map<String, Double> map = new HashMap<String,Double>();
		List<Map<String,Object>> results = query.getResultList();
		for (Map<String, Object> result: results){
			String horseName = result.get("HORSE_NAME").toString();
			Double adjTime = Double.parseDouble(result.get("AVG_ADJ_TIME").toString());
//			System.out.println(horseName + " " + adjTime); 
			for (CurrentOdd currentOdd: horseList){
				if (currentOdd.getHorseName().equals(horseName)){
					currentOdd.setAdjTime(adjTime);
				}
			}
			map.put(horseName, adjTime);
		}
		return horseList;
	}
}
