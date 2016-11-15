package com.techoffice.yahoo.finance.stock.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StockDao {
	@Autowired
	private SessionFactory sessionFactory;
	
}
