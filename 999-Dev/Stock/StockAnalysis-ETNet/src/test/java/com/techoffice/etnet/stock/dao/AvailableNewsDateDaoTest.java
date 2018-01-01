package com.techoffice.etnet.stock.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.techoffice.etnet.news.dao.AvailableNewsDateDao;
import com.techoffice.etnet.news.entity.AvailableNewsDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class AvailableNewsDateDaoTest {

	@Autowired
	private AvailableNewsDateDao availableNewsDateDao;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	@Transactional
	public void find(){
		Date postDate = new Date();
		AvailableNewsDate testData = new AvailableNewsDate();
		testData.setPostDate(postDate);
		availableNewsDateDao.add(testData);
		AvailableNewsDate availableNewsDate = availableNewsDateDao.find(postDate);
		Assert.notNull(availableNewsDate);
	}
	
	@Test
	@Transactional
	public void list(){
		AvailableNewsDate availableNewsDate = new AvailableNewsDate();
		availableNewsDate.setPostDate(new Date());
		List<AvailableNewsDate> list = availableNewsDateDao.list();
		log.info("List Size: " + list.size());
	}
	
	@Test
	@Transactional
	public void add(){
		AvailableNewsDate availableNewsDate = new AvailableNewsDate();
		availableNewsDate.setPostDate(new Date());
		availableNewsDateDao.add(availableNewsDate);
		log.info("List Size: " + availableNewsDateDao.count());
	}
	
	@Test
	@Transactional
	public void save(){
		log.info("List Size: " + availableNewsDateDao.count());
		Date postDate = new Date();
		AvailableNewsDate testData = new AvailableNewsDate();
		testData.setPostDate(postDate);
		availableNewsDateDao.save(testData);
		AvailableNewsDate availableNewsDate = availableNewsDateDao.find(postDate);
		availableNewsDate.setUrl("test");
		availableNewsDateDao.save(availableNewsDate);
		AvailableNewsDate availableNewsDate2 = availableNewsDateDao.find(postDate);
		log.info(availableNewsDate2.getUrl());
		Assert.notNull(availableNewsDate2);
		log.info("List Size: " + availableNewsDateDao.count());
	}
	
	@Test
	@Transactional
	public void deleteAll(){
		log.info("List Size: " + availableNewsDateDao.count());
		availableNewsDateDao.deleteAll();
		log.info("List Size: " + availableNewsDateDao.count());
	}
	
	@Test
	@Transactional
	public void delete(){
		log.info("List Size: " + availableNewsDateDao.count());
		Date postDate = new Date();
		AvailableNewsDate testData = new AvailableNewsDate();
		testData.setPostDate(postDate);
		availableNewsDateDao.add(testData);
		log.info("List Size: " + availableNewsDateDao.count());
		availableNewsDateDao.delete(testData);
		log.info("List Size: " + availableNewsDateDao.count());
	}
}
