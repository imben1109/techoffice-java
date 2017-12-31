package com.techoffice.etnet.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.etnet.news.service.ImmediateNewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class ImmediateNewsServiceTest {

	@Autowired
	private ImmediateNewsService ImmediateNewsService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void addCrawledImmediateNewsList(){
		ImmediateNewsService.addCrawledImmediateNewsList();
	}
	
	
}
