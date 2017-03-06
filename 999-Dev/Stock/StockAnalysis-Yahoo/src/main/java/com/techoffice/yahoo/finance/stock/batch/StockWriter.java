package com.techoffice.yahoo.finance.stock.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.techoffice.yahoo.finance.stock.model.Price;

public class StockWriter implements ItemWriter<List<Price>>{
	
	
	public void write(List<? extends List<Price>> items) throws Exception {
		for (List<Price> item: items){
			
		}
	}



}
