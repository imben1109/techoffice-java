package com.techoffice.aastock.stock.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.aastock.stock.model.JobTask;

@Repository
public class JobTaskDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void add(JobTask jobTask){
		em.persist(jobTask);
	}
	
}
