package com.techoffice.aastock.stock.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class StockDao {
	
	@PersistenceContext
	private EntityManager em;
	
}
