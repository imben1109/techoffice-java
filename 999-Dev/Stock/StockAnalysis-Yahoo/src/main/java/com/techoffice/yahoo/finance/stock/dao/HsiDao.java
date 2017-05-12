package com.techoffice.yahoo.finance.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.yahoo.finance.stock.model.Hsi;

@Repository
public class HsiDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void add(Hsi hsi){
		em.persist(hsi);
	}
	
	@Transactional
	public void add(List<Hsi> list){
		for (Hsi hsi: list){
			em.persist(hsi);
		}
	}
	
	@Transactional
	public List<Hsi> list(){
		TypedQuery<Hsi> query = em.createQuery("From Hsi", Hsi.class);
		return query.getResultList();
	}
	
	@Transactional
	public void removeAll(){
		em.createQuery("delete from Hsi").executeUpdate();
	}
}
