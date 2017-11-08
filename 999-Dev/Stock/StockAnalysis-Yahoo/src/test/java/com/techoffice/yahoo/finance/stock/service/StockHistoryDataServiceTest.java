package com.techoffice.yahoo.finance.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class StockHistoryDataServiceTest {
	
	@Autowired
	private PriceService stockHistoryDataService;
	
//	@Test
//	public void updateAllStockPrice() throws FailingHttpStatusCodeException, MalformedURLException, IllegalAccessException, InvocationTargetException, IOException{
//		stockHistoryDataService.updateAllStockPrice();
//	}
	
	@Test
	public void test(){
		
	}
}
