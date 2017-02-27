package com.techoffice.jc.horse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
