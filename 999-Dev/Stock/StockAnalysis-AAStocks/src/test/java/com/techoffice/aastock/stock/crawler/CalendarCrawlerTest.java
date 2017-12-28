package com.techoffice.aastock.stock.crawler;

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
public class CalendarCrawlerTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ResultAnnounceCalCrawler resultAnnounceCalCrawler;
	
	@Test
	public void retrieveStockListByWebClient() {
		int pageCount = resultAnnounceCalCrawler.getPageCount();
		log.info("Page Count: " + pageCount);
		Assert.isTrue(pageCount > 0);
	}
}
