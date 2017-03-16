package com.techoffice.yahoo.finance.stock.batch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.techoffice.hkex.csvimport.stock.dao.StockDao;
import com.techoffice.hkex.csvimport.stock.model.Stock;

public class StockPartitioner implements Partitioner{
	
	@Autowired
	private StockDao stockDao;
	
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> results = new HashMap<String, ExecutionContext>();
		
		List<Stock> list = stockDao.list();
		int listPartitionSize = (list.size() / gridSize) + 1;
		List<List<Stock>> partitionStockList = Lists.partition(list, listPartitionSize);
		
		for(int i=0; i<gridSize; i++){
			ExecutionContext context = new ExecutionContext();
			if (partitionStockList.size() > 0){
				context.put("stockList", new ArrayList<Stock>(partitionStockList.get(i)));
				results.put("partition-" + i, context);
			}else{
				context.put("stockList", new ArrayList<Stock>());
				results.put("partition-" + i, context);
			}
		}
		
		return results;
	}

}
