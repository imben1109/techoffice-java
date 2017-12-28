package com.techoffice.etnet.stock.realtime.crawler;

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
public class RealTimeStockCrawlerTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RealTimeStockCrawler realTimeStockCrawler;
	
	@Test
	public void retrieveXmlByCode(){
		String xml = realTimeStockCrawler.retrieveXmlByCode("00005");
		log.info(xml);
		Assert.hasText(xml);
	}
	
	@Test
	public void getCurrentPrice(){
		String currentPrice = realTimeStockCrawler.getCurrentPrice("00005");
		log.info(currentPrice);
		Assert.hasText(currentPrice);

	}
}
