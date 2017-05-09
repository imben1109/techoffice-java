package com.techoffice.yahoo.finance.stock.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.util.DateUtils;
import com.techoffice.yahoo.finance.stock.dao.PriceBatchDao;
import com.techoffice.yahoo.finance.stock.model.PriceBatch;

/**
 * Spring Batch Item Reader for Stock List.
 * 
 * @author imben1109
 *
 */
public class StockReader implements ItemReader<Stock>{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private List<Stock> stockList;
	
	@Autowired
	private PriceBatchDao priceBatchDao;
	
	/**
	 * Read Stock into next step. Skip the stock which has already executed today.
	 */
	public Stock read()  {
		if (!stockList.isEmpty()){
			Stock stock = stockList.remove(0);
			
			PriceBatch priceBatch = priceBatchDao.get(stock.getStockCode());
			if (priceBatch != null && priceBatch.getLastExecuted() != null && DateUtils.isToday(priceBatch.getLastExecuted())){
				log.info("Stock [" + priceBatch.getStockCode() + "] has already updated on " + DateUtils.format(priceBatch.getLastExecuted()));
				return read();
			}
			
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
