package com.techoffice.etnet.stock.realtime.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StockDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
}
