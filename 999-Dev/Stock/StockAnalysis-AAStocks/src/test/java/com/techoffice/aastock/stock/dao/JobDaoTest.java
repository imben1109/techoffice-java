package com.techoffice.aastock.stock.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.aastock.stock.model.Job;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
@Transactional
@Rollback(false)
public class JobDaoTest {

	@Autowired
	private JobDao jobDao;
	
	@Test
	public void add(){
		Job job = new Job();
		jobDao.add(job);
	}
	
	@Test
	public void listAll(){
		List<Job> jobs = jobDao.list();
		System.out.println(jobs.size());
		for (Job job: jobs){
			System.out.println(job.getId());
		}
	}
}
