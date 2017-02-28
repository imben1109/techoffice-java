package com.techoffice.yahoo.finance.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.yahoo.finance.stock.model.HsiStock;

@Repository
public class HsiStockDao {	
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void add(HsiStock hsiStock){
		em.persist(hsiStock);
	}
	
	@Transactional
	public void add(List<HsiStock> list){
		for (HsiStock hsiStock: list){
			em.persist(hsiStock);
		}
	}
	
	@Transactional
	public List<HsiStock> list(){
		TypedQuery<HsiStock> query = em.createQuery("From HsiStock", HsiStock.class);
		return query.getResultList();
	}
	
	@Transactional
	public void removeAll(){
		em.createQuery("delete from HsiStock").executeUpdate();
	}
}
