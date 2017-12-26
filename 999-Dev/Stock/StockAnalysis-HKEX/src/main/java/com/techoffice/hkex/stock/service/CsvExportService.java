package com.techoffice.hkex.stock.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.techoffice.hkex.stock.model.Stock;

@Component
public class CsvExportService {
	public void export(List<Stock> stocks) throws IOException{
		CSVWriter writer = new CSVWriter(new FileWriter("HKEX_STOCK_LIST.csv"));

		ColumnPositionMappingStrategy<Stock> strategy = new ColumnPositionMappingStrategy<Stock>();
		strategy.setType(Stock.class);
	    String[] columns = new String[]{"stockCode", "name", "chiName"};
	    strategy.setColumnMapping(columns);

		BeanToCsv<Stock> beanToCsv = new BeanToCsv<Stock>();
		beanToCsv.write(strategy, writer, stocks);
		writer.close();
	}
}
