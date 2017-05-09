package com.techoffice.yahoo.finance.stock.batch;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.yahoo.finance.stock.dao.PriceBatchDao;
import com.techoffice.yahoo.finance.stock.dao.PriceDao;
import com.techoffice.yahoo.finance.stock.model.Price;
import com.techoffice.yahoo.finance.stock.model.PriceBatch;

public class StockWriter implements ItemWriter<Map<String, Object>>{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	private PriceBatchDao priceBatchDao;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void write(List<? extends Map<String, Object>> results) {
		for (Map<String, Object> result: results){
			if (result.get("result").equals("success")){
				Stock stock = (Stock) result.get("stock");
				log.info("Now Writing: " + stock.getStockCode());
				priceDao.deletePrice(stock.getStockCode());
				List<Price> prices = (List<Price>) result.get("prices");
				priceDao.addPriceList(prices);
				PriceBatch priceBatch = priceBatchDao.get(stock.getStockCode());
				if (priceBatch == null){
					priceBatch = new PriceBatch();
					priceBatch.setStockCode(stock.getStockCode());
				}
				priceBatch.setLastExecuted(new Date());
				priceBatchDao.update(priceBatch);
				log.info("Stock [: " + stock.getStockCode() + "] - Updated");
			}
		}
	}

}
