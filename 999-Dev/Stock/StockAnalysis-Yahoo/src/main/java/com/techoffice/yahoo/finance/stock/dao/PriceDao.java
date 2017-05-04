package com.techoffice.yahoo.finance.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.yahoo.finance.stock.model.Price;

@Repository
public class PriceDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void deletePrice(String stockNo){
		Query query = em.createQuery("DELETE From Price Where stockNo = :stockNo");
		query.setParameter("stockNo", stockNo);
		query.executeUpdate();
	}
	
	@Transactional
	public void addPriceList(List<Price> priceList){
		for(Price price: priceList){
			em.persist(price);
		}
	}
	
	@Transactional
	public List<Price> getPriceList(){
		TypedQuery<Price> query = em.createQuery("from Price", Price.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<Price> getPriceList(String stockNo){
		TypedQuery<Price> query = em.createQuery("from Price where stockNo = :stockNo ", Price.class);
		query.setParameter("stockNo", stockNo);
		return query.getResultList();
	}
}
