package com.techoffice.etnet.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.etnet.news.service.AvailableNewsDateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class AvailableNewsDateServiceTest {

	@Autowired
	private AvailableNewsDateService availableNewsDateService;
	
	@Test
	public void saveCrawledAvailableDateList(){
		availableNewsDateService.saveCrawledAvailableDateList();
	}
	
	@Test
	public void saveCrawledImmediateNewsListWithNotRunAvailableDate(){
		availableNewsDateService.saveCrawledImmediateNewsListWithNotRunAvailableDate();
	}
}
