package com.techoffice.yahoo.finance.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.yahoo.finance.stock.model.HsiStock;

@Repository
public class HsiStockDao {	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void add(HsiStock hsiStock){
		Session session = sessionFactory.getCurrentSession();
		session.persist(hsiStock);
	}
	
	@Transactional
	public void add(List<HsiStock> list){
		Session session = sessionFactory.getCurrentSession();
		for (HsiStock hsiStock: list){
			session.persist(hsiStock);
		}
	}
	
	@Transactional
	public List<HsiStock> list(){
		Session session = sessionFactory.getCurrentSession();
		Query<HsiStock> query = session.createQuery("From HsiStock", HsiStock.class);
		return query.getResultList();
	}
	
	@Transactional
	public void removeAll(){
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from HsiStock").executeUpdate();
	}
}
