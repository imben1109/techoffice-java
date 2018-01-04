package com.techoffice.hkex.stock.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techoffice.hkex.stock.model.Stock;
import com.techoffice.reader.base.BaseExcelReader;

@Component
public class StockExcelReader extends BaseExcelReader<List<Stock>> {

	@Override
	public InputStream getConfigInputStream() {
		return this.getClass().getResourceAsStream("stockExcelReaderConfig.xml");
	}

	@Override
	public List<Stock> getBean() {
		return new ArrayList<Stock>();
	}

}
