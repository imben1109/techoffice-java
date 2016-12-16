package com.techoffice.oracle.client.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SqlDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void doSomethiing(){
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select TABLE_NAME from user_tables");
		for (Map<String, Object> item: list){
			System.out.println(item.get("TABLE_NAME"));
		}
	}
}
