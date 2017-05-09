package com.techoffice.yahoo.finance.stock.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.hkex.csvimport.stock.dao.StockDao;
import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.yahoo.finance.stock.crawler.PriceCrawler;
import com.techoffice.yahoo.finance.stock.dao.PriceDao;
import com.techoffice.yahoo.finance.stock.model.Price;

@Service
public class PriceService {
	
	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private PriceCrawler stockHistoryDataCrawler;
	
	public void updateAllStockPrice() throws IllegalAccessException, InvocationTargetException, IOException {
		List<Stock> stocks = stockDao.list();
		for (Stock stock: stocks){
			System.out.println(stock.getName());
			String stockCode = stock.getStockCode().substring(1);
			List<Price> prices = stockHistoryDataCrawler.retrieveHistoryPriceData(stockCode);
			priceDao.addPriceList(prices);
		}
	}
}
