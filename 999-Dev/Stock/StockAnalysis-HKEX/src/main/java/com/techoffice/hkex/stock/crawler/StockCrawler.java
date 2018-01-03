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

	public static final String URL = "http://www.hkex.com.hk/Products/Securities/Equities/Equity-Warrants?sc_lang=en";
	
	public String getXml() {
		return WebDriverUtil.getXml(URL);
	}
	
	public String getStockListXlsFileUrl(){
		String xPath = "/html/body/form/div[8]/main/section/div[2]/div[1]/p[2]/a";
		String xml = getXml();
		Node node = XmlUtil.evaluateXpathNode(xml, xPath);
		String url = node.getAttributes().getNamedItem("href").getNodeValue();
		return url;
	}
	
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
