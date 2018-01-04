package com.techoffice.hkex.stock.crawler;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.hkex.stock.model.Stock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class StockCrawlerTest {

	@Autowired
	private StockCrawler stockCrawler;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void downloadStockListXmlFile(){
		File file = stockCrawler.downloadStockListXmlFile();
		log.info(file.getAbsolutePath());
	}
	
	@Test
	public void getStockList(){
		List<Stock> stockList = stockCrawler.getStockList();
		log.info("count: " + stockList.size());
	}
	
}
