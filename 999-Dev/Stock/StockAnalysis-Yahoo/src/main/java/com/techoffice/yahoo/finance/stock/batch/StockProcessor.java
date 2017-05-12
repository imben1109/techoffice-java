package com.techoffice.yahoo.finance.stock.batch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.yahoo.finance.stock.crawler.PriceCrawler;
import com.techoffice.yahoo.finance.stock.model.Price;

public class StockProcessor implements ItemProcessor<Stock, Map<String, Object>>{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PriceCrawler priceCrawler;
	
	public Map<String, Object> process(Stock stock)  {
		log.info("Now processing: " + stock.getStockCode());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("stock", stock);
		List<Price> prices = new ArrayList<Price>();;
		try {
			prices = priceCrawler.retrieveStockHistoryPrice(stock.getStockCode().substring(1));
			result.put("result", "success");
		} catch (Exception e) {
			result.put("result", "fail");
			result.put("exception", e);
		}
		result.put("prices", prices);
		return result;
	}

}
