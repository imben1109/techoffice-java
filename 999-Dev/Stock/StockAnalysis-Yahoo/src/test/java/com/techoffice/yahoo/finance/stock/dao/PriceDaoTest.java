package com.techoffice.yahoo.finance.stock.dao;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.yahoo.finance.stock.crawler.PriceCrawler;
import com.techoffice.yahoo.finance.stock.model.Price;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class PriceDaoTest {
	
	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	private PriceCrawler stockHistoryDataCrawler;
	
//	@Test
//	public void deletePrice() throws FailingHttpStatusCodeException, MalformedURLException, IllegalAccessException, InvocationTargetException, IOException{
//		List<Price> prices1 = priceDao.getPriceList("0939");
//		System.out.println("Stock 0939 Record Count in Database: " + prices1.size());
//		priceDao.deletePrice("0939");
//		System.out.println("Record of Stock 0930 is removed.");
//		List<Price> prices2 = priceDao.getPriceList("0939");
//		System.out.println("Stock 0939 Record Count in Database: " + prices2.size());
//		List<Price> prices3 =stockHistoryDataCrawler.retrieveHistoryPriceData("0939");
//		priceDao.addPriceList(prices3);
//		System.out.println("Retrieve Stock 0939 Price Data from Internet and Insert into Database.");
//		List<Price> prices4 = priceDao.getPriceList("0939");
//		System.out.println("Stock 0939 Record Count in Database: " + prices4.size());
//	}
	
	@Test
	public void test(){
		
	}
}
