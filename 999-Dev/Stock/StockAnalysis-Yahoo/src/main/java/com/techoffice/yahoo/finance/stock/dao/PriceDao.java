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
	public void delete(String stockNo){
		Query query = em.createQuery("DELETE From Price Where stockNo = :stockNo");
		query.setParameter("stockNo", stockNo);
		query.executeUpdate();
	}
	
	@Transactional
	public void add(List<Price> priceList){
		for(Price price: priceList){
			em.persist(price);
		}
	}
	
	@Transactional
	public List<Price> list(){
		TypedQuery<Price> query = em.createQuery("from Price", Price.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<Price> list(String stockNo){
		TypedQuery<Price> query = em.createQuery("from Price where stockNo = :stockNo ", Price.class);
		query.setParameter("stockNo", stockNo);
		return query.getResultList();
	}
}
