package com.techoffice.example;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class Appl {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@Autowired
    @Qualifier("dataSource")
	private RoutingDataSource datasource;
	
	@Autowired
	private TableDao tableDao;

	private JdbcTemplate jdbcTemplate;
	
	public Appl(){
		System.out.println("Tech Office Spring Data Access Example");
	}
	
	@Transactional()
	public void run(){
		System.out.println("Inserting into DataSource 1");
		datasource.setDateSourceKey("dataSource1");
		tableDao.createTable();
		tableDao.insertData();
		tableDao.insertData2();
		tableDao.count();
		System.out.println("Inserting into DataSource 2");
		datasource.setDateSourceKey("dataSource2");
		tableDao.createTable();
		tableDao.insertData();
		tableDao.insertData2();
		tableDao.count();
	}
	
	public static void main(String[] args){
		String a = "";
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
