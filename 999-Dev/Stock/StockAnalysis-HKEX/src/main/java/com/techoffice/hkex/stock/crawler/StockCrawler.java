package com.techoffice.hkex.stock.crawler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;

import com.techoffice.hkex.stock.crawler.exception.StockCrawlerException;
import com.techoffice.util.UrlUtil;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

@Component
public class StockCrawler {
	
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


	
}
