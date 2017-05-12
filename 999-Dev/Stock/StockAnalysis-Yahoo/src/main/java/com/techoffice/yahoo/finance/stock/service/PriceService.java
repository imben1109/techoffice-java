package com.techoffice.yahoo.finance.stock.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.hkex.csvimport.stock.dao.StockDao;
import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.yahoo.finance.stock.crawler.PriceCrawler;
import com.techoffice.yahoo.finance.stock.dao.PriceDao;
import com.techoffice.yahoo.finance.stock.model.Price;

@Service
public class PriceService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private PriceCrawler stockHistoryDataCrawler;
	
	public void updateAllStockPrice() throws IllegalAccessException, InvocationTargetException, IOException {
		List<Stock> stocks = stockDao.list();
		for (Stock stock: stocks){
			log.info("Updating Price of Stock [" + stock.getName() + "]");
			String stockCode = stock.getStockCode().substring(1);
			List<Price> prices = stockHistoryDataCrawler.retrieveStockHistoryPrice(stockCode);
			priceDao.add(prices);
		}
	}
	
	@Transactional
	public List<Price> list(String stockNo){
		return priceDao.list(stockNo);
	}
}
