package com.techoffice.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

public interface TestDao {

	public void search(Map map);
	
	public void insert(Map map);
	
	public void update(Map map);
	
	public void delete(Map map);
}
