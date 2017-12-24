package com.techoffice.hkex.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.hkex.stock.model.Stock;

@Repository
public class StockDao {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public List<Stock> list(){
		List<Stock> results = em.createQuery("From Stock", Stock.class).getResultList();
		return results;
	}
	
	@Transactional
	public int clear(){
		TypedQuery<Integer> query = em.createQuery("DELETE FROM Stock", Integer.class);
		return query.executeUpdate();
	}
	
	@Transactional
	public String save(Stock stock){
		em.persist(stock);
		System.out.println("created: " + stock.getStockCode());
		return "";
	}
	
}
