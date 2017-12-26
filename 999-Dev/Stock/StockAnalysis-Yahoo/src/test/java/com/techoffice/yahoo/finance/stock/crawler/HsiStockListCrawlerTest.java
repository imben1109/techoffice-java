package com.techoffice.yahoo.finance.stock.crawler;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.yahoo.finance.stock.model.HsiStock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class HsiStockListCrawlerTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HsiStockCrawler hsiStockCrawler;
	
	@Test
	public void retrieveStockList() {
		List<HsiStock> hsiStockList = hsiStockCrawler.retrieveStockList();
		for (HsiStock stock: hsiStockList){
			log.info(stock.getChiName());
		}
	}
	
	@Test
	public void test(){
		
	}
}
