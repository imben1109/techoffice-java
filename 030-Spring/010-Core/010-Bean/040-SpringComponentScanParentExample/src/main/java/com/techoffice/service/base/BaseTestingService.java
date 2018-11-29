package com.techoffice.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.techoffice.dao.base.BaseTestingDao;

public abstract class BaseTestingService {

	@Autowired
	private BaseTestingDao baseTestingDao;
	
	public void doSomething1(){
		baseTestingDao.printHelloWorld();
	}
	
}
