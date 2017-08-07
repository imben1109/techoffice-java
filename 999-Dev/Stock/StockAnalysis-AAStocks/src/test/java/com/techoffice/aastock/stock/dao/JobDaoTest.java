package com.techoffice.aastock.stock.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.aastock.stock.model.Job;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
@Transactional
public class JobDaoTest {

	@Autowired
	private JobDao jobDao;
	
	@Test
	public void add(){
		Job job = new Job();
		jobDao.add(job);
	}
}
