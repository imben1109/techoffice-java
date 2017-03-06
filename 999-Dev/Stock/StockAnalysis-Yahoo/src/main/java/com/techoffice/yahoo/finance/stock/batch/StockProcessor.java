package com.techoffice.yahoo.finance.stock.batch;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.yahoo.finance.stock.crawler.StockHistoryDataCrawler;
import com.techoffice.yahoo.finance.stock.model.Price;

public class StockProcessor implements ItemProcessor<Stock, List<Price>>{

	@Autowired
	private StockHistoryDataCrawler stockHistoryDataCrawler;
	
	public List<Price> process(Stock stock) throws Exception {
		System.out.println("Now processing: " + stock.getStockCode());
		List<Price> prices = stockHistoryDataCrawler.retrieveHistoryPriceData(stock.getStockCode().substring(1));
		return prices;
	}

}
