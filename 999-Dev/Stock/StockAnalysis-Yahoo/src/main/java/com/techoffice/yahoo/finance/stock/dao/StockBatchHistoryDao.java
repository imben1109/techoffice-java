package com.techoffice.yahoo.finance.stock.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.yahoo.finance.stock.service.StockBatchHistory;

@Repository
public class StockBatchHistoryDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public StockBatchHistory get(String stockCode){
		StockBatchHistory stockBatchHistory = em.find(StockBatchHistory.class, stockCode);
		return stockBatchHistory;
	}
	
	@Transactional
	public StockBatchHistory add(StockBatchHistory stockBatchHistory){
		em.persist(stockBatchHistory);
		return stockBatchHistory;
	}
	
	@Transactional
	public StockBatchHistory update(StockBatchHistory stockBatchHistory){
		stockBatchHistory = em.merge(stockBatchHistory);
		return stockBatchHistory;
	}
}
