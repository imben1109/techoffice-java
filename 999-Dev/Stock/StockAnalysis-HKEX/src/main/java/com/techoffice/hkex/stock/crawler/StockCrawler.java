package com.techoffice.hkex.stock.crawler;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.hkex.stock.crawler.exception.StockCrawlerException;
import com.techoffice.hkex.stock.model.Stock;
import com.techoffice.hkex.stock.reader.StockExcelReader;
import com.techoffice.util.UrlUtil;

@Component
public class StockCrawler {
	
	@Autowired
	private StockExcelReader stockExcelReader;
	
	final Logger log = LoggerFactory.getLogger(this.getClass());		

	public static final String URL = "http://www.hkex.com.hk/eng/services/trading/securities/securitieslists/ListOfSecurities.xlsx";
	
	public File downloadStockListXmlFile() {
		try {
			File file = File.createTempFile("HKEX", ".tmp");
			file.deleteOnExit();
			file = UrlUtil.downloadToFile(URL, file);
			return file;
		} catch (Exception e) {
			throw new StockCrawlerException(e);
		}
	}

	public List<Stock> getStockList(){
		File file = downloadStockListXmlFile();
		return stockExcelReader.read(file);
	}

	
}
