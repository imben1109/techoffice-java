package com.techoffice.aastock.stock.crawler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TopNewsCrawlerTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TopNewsCrawler topNewsCrawler;

	@Test
	public void retrieve(){
		topNewsCrawler.retrieve();
	}
}
