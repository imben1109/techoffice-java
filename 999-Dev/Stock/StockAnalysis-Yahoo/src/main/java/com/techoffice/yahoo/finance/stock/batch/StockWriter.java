package com.techoffice.yahoo.finance.stock.batch;

import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.yahoo.finance.stock.dao.PriceDao;
import com.techoffice.yahoo.finance.stock.dao.StockBatchHistoryDao;
import com.techoffice.yahoo.finance.stock.model.Price;
import com.techoffice.yahoo.finance.stock.service.StockBatchHistory;

public class StockWriter implements ItemWriter<Map<String, Object>>{
	
	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	private StockBatchHistoryDao stockBatchHistoryDao;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void write(List<? extends Map<String, Object>> results) {
		for (Map<String, Object> result: results){
			if (result.get("result").equals("success")){
				Stock stock = (Stock) result.get("stock");
				System.out.println("Now Writing: " + stock.getStockCode());
				priceDao.deletePrice(stock.getStockCode());
				List<Price> prices = (List<Price>) result.get("prices");
				priceDao.addPriceList(prices);
				StockBatchHistory stockBatchHistory = stockBatchHistoryDao.get(stock.getStockCode());
				
			}
		}
	}

}
