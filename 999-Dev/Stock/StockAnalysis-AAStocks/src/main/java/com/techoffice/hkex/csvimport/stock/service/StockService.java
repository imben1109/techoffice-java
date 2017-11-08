package com.techoffice.hkex.csvimport.stock.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.techoffice.hkex.csvimport.stock.dao.StockDao;
import com.techoffice.hkex.csvimport.stock.model.Stock;

/**
 * Stock Service 
 * 
 * @author imben1109
 *
 */
@Service
public class StockService {
	
	@Autowired
	private StockDao stockDao;
	
	public List<Stock> list(){
		return stockDao.list();
	}
	
	@Transactional
	public void uploadStockList() throws IOException{
		File defaultCsvFile = new File(this.getClass().getClassLoader().getResource("HKEX_STOCK_LIST.csv").getFile());
		updateStockList(defaultCsvFile);
	}
	
	
	@Transactional
	public void updateStockList(File file) throws IOException{
		List<Stock> stocks = importStockList(file);
		stockDao.clear();
		stockDao.save(stocks);
	}
	
	@Transactional
	public List<Stock> importStockList(File file) throws IOException{
		CSVReader reader = new CSVReader(new FileReader(file));
		HeaderColumnNameMappingStrategy<Stock> strategy = new HeaderColumnNameMappingStrategy<Stock>();
		strategy.setType(Stock.class);
		
		CsvToBean<Stock> csvToBean = new CsvToBean<Stock>();
		List<Stock> stocks = csvToBean.parse(strategy, reader);
		reader.close();
		return stocks;
	}
}
