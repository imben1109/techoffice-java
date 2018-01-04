package com.techoffice.hkex.stock.reader;

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
public class StockExcelReaderTest {

	@Autowired
	private StockExcelReader stockExcelReader;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void read(){
		List<Stock> list = stockExcelReader.read(new File("ListOfSecurities.xlsx"));
		log.info("count: " + list.size());
		for (Stock stock: list){
			log.info(stock.getStockCode() + " " + stock.getName());
		}
	}
	
}
