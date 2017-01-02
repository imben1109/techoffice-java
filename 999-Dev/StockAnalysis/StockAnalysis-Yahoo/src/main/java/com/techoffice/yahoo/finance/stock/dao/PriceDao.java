package com.techoffice.yahoo.finance.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.yahoo.finance.stock.model.Price;

@Repository
public class PriceDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public void deletePrice(String stockNo){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE From Price Where stockNo = :stockNo");
		query.setParameter("stockNo", stockNo);
		query.executeUpdate();
	}
	
	@Transactional
	public void addPriceList(List<Price> priceList){
		Session session = sessionFactory.getCurrentSession();
		for(Price price: priceList){
			session.persist(price);
		}
	}
	
	@Transactional
	public List<Price> getPriceList(){
		Session session = sessionFactory.getCurrentSession();
		Query<Price> query = session.createQuery("from Price", Price.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<Price> getPriceList(String stockNo){
		Session session = sessionFactory.getCurrentSession();
		Query<Price> query = session.createQuery("from Price where stockNo = :stockNo ", Price.class);
		query.setParameter("stockNo", stockNo);
		return query.getResultList();
	}
}
