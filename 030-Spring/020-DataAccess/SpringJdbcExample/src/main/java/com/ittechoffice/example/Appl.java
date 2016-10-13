package com.ittechoffice.example;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class Appl {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private TableDao tableDao;

	private JdbcTemplate jdbcTemplate;
	
	public Appl(){
		System.out.println("IT Tech Office Spring Data Access Example");
	}
	
	@Transactional()
	public void run(){
//		tableDao.createTable();
		tableDao.insertData();
		tableDao.insertData2();
		tableDao.count();
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
