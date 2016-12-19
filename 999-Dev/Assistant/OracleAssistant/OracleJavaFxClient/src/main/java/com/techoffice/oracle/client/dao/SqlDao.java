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
	
	public List<Map<String, Object>> execute(String sql){
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
		return results;
	}
}
