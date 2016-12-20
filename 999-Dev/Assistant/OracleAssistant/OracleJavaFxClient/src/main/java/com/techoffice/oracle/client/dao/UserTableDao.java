package com.techoffice.oracle.client.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserTableDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> selectTableList() {
		List<String> results = jdbcTemplate.queryForList("SELECT TABLE_NAME FROM USER_TABLES", String.class);
		return results;
	}
}
