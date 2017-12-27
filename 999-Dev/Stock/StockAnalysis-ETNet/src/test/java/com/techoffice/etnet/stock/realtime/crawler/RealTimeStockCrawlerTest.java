package com.techoffice.etnet.stock.realtime.crawler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class RealTimeStockCrawlerTest {

	@Autowired
	private RealTimeStockCrawler realTimeStockCrawler;
	
	@Test
	public void retrieveXmlByCode(){
		realTimeStockCrawler.retrieveXmlByCode("00005");
	}
}
