package com.techoffice.util.service;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicDataSourceService {
	
	@Autowired
	private BasicDataSource basicDataSource;
	
	public int getNumActive(){
		return basicDataSource.getNumActive();
	}
	
	public int getNumIdle(){
		return basicDataSource.getNumIdle();
	}
}
