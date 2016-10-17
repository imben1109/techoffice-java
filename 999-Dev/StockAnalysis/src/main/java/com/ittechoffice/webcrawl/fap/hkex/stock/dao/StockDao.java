package com.ittechoffice.webcrawl.fap.hkex.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ittechoffice.webcrawl.fap.hkex.stock.model.Stock;

@Repository
public class StockDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Stock> list(){
		Session session = sessionFactory.getCurrentSession();
		List<Stock> results = session.createQuery("From Stock").list();
		return results;
	}
	
	@Transactional
	public String save(Stock stock){
		Session session = sessionFactory.getCurrentSession();
		String id = (String) session.save(stock);
		System.out.println("created: " + id);
		return id;
	}
	
}
