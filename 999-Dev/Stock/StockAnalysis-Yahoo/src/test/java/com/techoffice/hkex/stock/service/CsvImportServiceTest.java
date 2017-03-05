package com.techoffice.hkex.stock.service;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.hkex.csvimport.stock.dao.StockDao;
import com.techoffice.hkex.csvimport.stock.service.CsvImportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class CsvImportServiceTest {
	
	@Autowired
	private CsvImportService csvImportService;
	
	@Autowired
	private StockDao stockDao;
	
//	@Test
//	public void updateStockList() throws IOException{
//		csvImportService.updateStockList();
//		System.out.println(stockDao.list().size());
//	}
	
	@Test
	public void test(){
		
	}
}
