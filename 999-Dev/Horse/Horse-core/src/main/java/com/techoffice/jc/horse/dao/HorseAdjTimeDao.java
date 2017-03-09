package com.techoffice.jc.horse.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.dto.CurrentOdd;

@Repository
public class HorseAdjTimeDao {
	
	@PersistenceContext
	private EntityManager em;
	
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
		
		Query query = em.createNativeQuery("SELECT HORSE_NAME, AVG_ADJ_TIME FROM HORSE_ADJ_TIME WHERE HORSE_NAME in " + horseQuery + " ORDER BY AVG_ADJ_TIME ASC");
		Map<String, Double> map = new HashMap<String,Double>();
		List<Object[]> results = query.getResultList();
		for (Object[] result: results){
			String horseName = result[0].toString();
			Double adjTime = Double.parseDouble(result[1].toString());
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
