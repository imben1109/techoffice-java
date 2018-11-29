package com.techoffice.dao;

import org.springframework.stereotype.Component;

import com.techoffice.dao.base.BaseTestingDao;

@Component
public class TestingDao extends BaseTestingDao{

	@Override
	public void printHelloWorld() {
		System.out.println("HelloWorld 1");		
	}

}
