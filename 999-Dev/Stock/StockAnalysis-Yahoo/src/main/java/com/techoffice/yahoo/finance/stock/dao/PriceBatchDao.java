package com.techoffice.yahoo.finance.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.yahoo.finance.stock.model.PriceBatch;

@Repository
public class PriceBatchDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public PriceBatch get(String stockCode){
		PriceBatch stockBatchHistory = em.find(PriceBatch.class, stockCode);
		return stockBatchHistory;
	}
	
	@Transactional
	public PriceBatch add(PriceBatch stockBatchHistory){
		em.persist(stockBatchHistory);
		return stockBatchHistory;
	}
	
	@Transactional
	public PriceBatch update(PriceBatch priceBatch){
		priceBatch = em.merge(priceBatch);
		return priceBatch;
	}
	
	@Transactional
	public List<PriceBatch> list(){
		TypedQuery<PriceBatch> query = em.createQuery("select b from PriceBatch b", PriceBatch.class);
		return query.getResultList();
	}
}
