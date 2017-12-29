package com.techoffice.aastock.stock.crawler;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TopNewsCrawlerTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TopNewsCrawler topNewsCrawler;

	@Test
	public void retrieve(){
		List<String> newsList = topNewsCrawler.getNewsList();
		Assert.notEmpty(newsList);
		for (String news: newsList){
			log.info(news);
		}
	}
}
