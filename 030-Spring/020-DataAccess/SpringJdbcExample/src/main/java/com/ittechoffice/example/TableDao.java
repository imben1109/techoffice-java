package com.ittechoffice.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TableDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createTable(){
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS TEST1 (COLUMN1 VARCHAR2, COLUMN2 VARCHAR2, COLUMN3 VARCHAR2)");
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS TEST2 (COLUMN1 INT, COLUMN2 VARCHAR2, COLUMN3 VARCHAR2)");
	}
	
	public void insertData(){
		int row = jdbcTemplate.update("INSERT INTO TEST2 VALUES (1, 'CDE', 'DEF')");
		System.out.println((row) + " row inserted");
	}
	
	@Transactional(readOnly=true)
	public void insertData2(){
		int row = jdbcTemplate.update("INSERT INTO TEST2 VALUES (2, 'CDE', 'DEF')");
		System.out.println((row) + " row inserted");
	}
	
	public void count(){
		int count = jdbcTemplate.queryForObject("select count(1) from test2", Integer.class);
		System.out.println("Totol count: "+ count);
	}
}
