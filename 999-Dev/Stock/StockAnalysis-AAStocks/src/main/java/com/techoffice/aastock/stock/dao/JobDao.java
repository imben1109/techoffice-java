package com.techoffice.aastock.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.aastock.stock.model.Job;

@Repository
public class JobDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Job> list(){
		TypedQuery<Job> query = em.createQuery("from Job", Job.class);
		return query.getResultList();
	}
	
	@Transactional
	public void add(Job job){
		em.persist(job);
	}
	
}
