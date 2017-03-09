package com.techoffice.yahoo.finance.stock.crawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.techoffice.yahoo.finance.stock.dto.CsvPrice;
import com.techoffice.yahoo.finance.stock.model.Price;

@Component
public class StockHistoryDataCrawler {
	public static final String URL = "http://real-chart.finance.yahoo.com/table.csv?a=00&b=1&c=1900&d=11&e=31&f=2099&g=d&ignore=.csv&s={0}.HK";
	
	public List<Price> retrieveHistoryPriceData(String stockNo) throws IOException, IllegalAccessException, InvocationTargetException  {
		URL website = new URL(MessageFormat.format(URL, stockNo));
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		File csvFile = File.createTempFile("TECHOFFICE_YAHOO_", ".csv");
		csvFile.deleteOnExit();
		FileOutputStream fos = new FileOutputStream(csvFile);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		List<Price> prices = convertFileToPriceList(csvFile);
		for (Price price: prices){
			price.setStockNo(stockNo);
		}
		return prices;
	}
	
	public List<Price> convertFileToPriceList(File file) throws IOException, IllegalAccessException, InvocationTargetException{
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Date", "priceDate");
		mapping.put("Open", "open");
		mapping.put("High", "high");
		mapping.put("Low", "low");
		mapping.put("Close", "close");
		mapping.put("volumn", "volumn");
		mapping.put("Adj Close", "adjClose");
		CSVReader reader = new CSVReader(new FileReader(file.getAbsolutePath()));
		HeaderColumnNameTranslateMappingStrategy<CsvPrice> strategy = new HeaderColumnNameTranslateMappingStrategy<CsvPrice>();
		strategy.setType(CsvPrice.class);
		strategy.setColumnMapping(mapping);
		CsvToBean<CsvPrice> csvToBean = new CsvToBean<CsvPrice>();
		List<CsvPrice> prices = csvToBean.parse(strategy, reader);
		reader.close();
		List<Price> priceList = convertCsvPriceToPrice(prices);
		return priceList;
	}
	
	public List<Price> convertCsvPriceToPrice(List<CsvPrice> csvPriceList) throws IllegalAccessException, InvocationTargetException{


		List<Price> priceList = new ArrayList<Price>();
		
		for (CsvPrice csvPrice: csvPriceList){
			Price price = new Price();
			DateConverter dateConverter = new DateConverter();
			dateConverter.setPattern("yyyy-MM-dd");
			ConvertUtils.register(dateConverter, java.util.Date.class);
			BeanUtils.copyProperties(price, csvPrice);
			priceList.add(price);
		}
		
		return priceList;
	}
	

}
