package com.techoffice.etnet.stock.realtime.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class StockDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
}
