package com.techoffice.yahoo.finance.stock.service.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.techoffice.yahoo.finance.stock.dto.CsvPrice;

@Component
public class StockHistoryDataWebService {
	public static final String URL = "http://real-chart.finance.yahoo.com/table.csv?a=00&b=1&c=1900&d=11&e=31&f=2099&g=d&ignore=.csv&s={0}.HK";
	
	public String downloadHistoryData() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		URL website = new URL(MessageFormat.format(URL, "0939"));
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		File f = File.createTempFile("TECHOFFICE_YAHOO_", ".csv");
		f.deleteOnExit();
		FileOutputStream fos = new FileOutputStream(f);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		System.out.println(f.getAbsolutePath());
		convertFileToPriceList(f);
		return "";
	}
	
	public List<CsvPrice> convertFileToPriceList(File file) throws IOException{
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Date", "date");
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
		for(CsvPrice price: prices){
			System.out.println(price.getClose());
		}
		return prices;
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		StockHistoryDataWebService stockListWeb = new StockHistoryDataWebService();
		String xml = stockListWeb.downloadHistoryData();
		System.out.println(xml);
	}
}
