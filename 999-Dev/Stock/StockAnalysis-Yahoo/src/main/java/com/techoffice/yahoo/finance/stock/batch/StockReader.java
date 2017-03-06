package com.techoffice.yahoo.finance.stock.batch;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.techoffice.hkex.csvimport.stock.model.Stock;

public class StockReader implements ItemReader<Stock>{

	private List<Stock> stockList;
	
	public Stock read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (!stockList.isEmpty()){
			Stock stock = stockList.remove(0);
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
