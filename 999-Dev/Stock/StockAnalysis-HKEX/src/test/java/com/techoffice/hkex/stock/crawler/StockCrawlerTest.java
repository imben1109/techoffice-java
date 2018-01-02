package com.techoffice.hkex.stock.crawler;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
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
public class StockCrawlerTest {

	@Autowired
	private StockCrawler stockCrawler;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getStockListXlsFileUrl(){
		String url = stockCrawler.getStockListXlsFileUrl();
		log.info(url);
		Assert.isTrue(StringUtils.isNotEmpty(url));
	}
	
	@Test
	public void downloadStockListXmlFile(){
		File file = stockCrawler.downloadStockListXmlFile();
		log.info(file.getAbsolutePath());
	}
	
}
