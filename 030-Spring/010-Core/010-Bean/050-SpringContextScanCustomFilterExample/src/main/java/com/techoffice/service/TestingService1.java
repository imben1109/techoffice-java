package com.techoffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.dao.TestingDao;
import com.techoffice.service.base.BaseTestingService;

@Component("test1")
public class TestingService1 extends BaseTestingService{

	@Autowired
	private TestingDao testingDao;

	@Override
	public void doSomething1(){
		super.doSomething1();
		testingDao.printHelloWorld();
	}
}
