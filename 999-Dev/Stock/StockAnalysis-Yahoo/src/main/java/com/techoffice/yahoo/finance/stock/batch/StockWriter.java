package com.techoffice.yahoo.finance.stock.batch;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.yahoo.finance.stock.model.Price;
import com.techoffice.yahoo.finance.stock.service.PriceBatchService;

public class StockWriter implements ItemWriter<Map<String, Object>>{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PriceBatchService priceBatchService;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void write(List<? extends Map<String, Object>> results) {
		for (Map<String, Object> result: results){
			if (result.get("result").equals("success")){
				Stock stock = (Stock) result.get("stock");
				List<Price> prices = (List<Price>) result.get("prices");
				priceBatchService.updatePrices(stock, prices);
			}
		}
	}

}
