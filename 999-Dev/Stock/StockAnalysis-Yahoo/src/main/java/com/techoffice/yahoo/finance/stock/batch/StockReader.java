package com.techoffice.yahoo.finance.stock.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;

import com.techoffice.hkex.csvimport.stock.model.Stock;

public class StockReader implements ItemReader<Stock>{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private List<Stock> stockList;
	
	public Stock read()  {
		if (!stockList.isEmpty()){
			Stock stock = stockList.remove(0);
			log.info("Now Reading: " + stock.getStockCode());
			return stock;
		}
		return null;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}


	
}
