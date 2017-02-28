package com.techoffice.hkex.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.hkex.stock.model.Stock;

@Repository
public class StockDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Stock> list(){
		Session session = sessionFactory.getCurrentSession();
		List<Stock> results = session.createQuery("From Stock", Stock.class).getResultList();
		return results;
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public int clear(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM Stock");
		return query.executeUpdate();
	}
	
	@Transactional
	public String save(Stock stock){
		Session session = sessionFactory.getCurrentSession();
		String id = (String) session.save(stock);
		System.out.println("created: " + id);
		return id;
	}
	
	@Transactional
	public void save(List<Stock> stocks){
		for(Stock stock: stocks){
			this.save(stock);
		}
	}
	
}
