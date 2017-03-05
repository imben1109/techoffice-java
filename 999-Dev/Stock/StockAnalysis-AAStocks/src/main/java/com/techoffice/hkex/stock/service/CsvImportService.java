package com.techoffice.hkex.stock.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.techoffice.hkex.stock.dao.StockDao;
import com.techoffice.hkex.stock.model.Stock;

@Component
public class CsvImportService {
	
	@Autowired
	private StockDao stockDao;
	
	public void updateStockList() throws IOException{
		List<Stock> stocks = importStockList();
		stockDao.clear();
		stockDao.save(stocks);
	}
	
	@Transactional
	public List<Stock> importStockList() throws IOException{
		System.out.println(this.getClass().getClassLoader().getResource("HKEX_STOCK_LIST.csv").getFile());
		CSVReader reader = new CSVReader(new FileReader(this.getClass().getClassLoader().getResource("HKEX_STOCK_LIST.csv").getFile()));
		HeaderColumnNameMappingStrategy<Stock> strategy = new HeaderColumnNameMappingStrategy<Stock>();
		strategy.setType(Stock.class);
		
		CsvToBean<Stock> csvToBean = new CsvToBean<Stock>();
		List<Stock> stocks = csvToBean.parse(strategy, reader);
		reader.close();
		return stocks;
	}
}
