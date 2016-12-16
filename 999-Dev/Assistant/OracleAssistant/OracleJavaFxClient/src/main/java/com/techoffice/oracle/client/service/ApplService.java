package com.techoffice.oracle.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.client.dao.SqlDao;

@Service
public class ApplService {
	
	@Autowired
	private SqlDao sqlDao;
	
	public void doSomething(){
		sqlDao.doSomethiing();
		System.out.println("Do Something");
	}
}
