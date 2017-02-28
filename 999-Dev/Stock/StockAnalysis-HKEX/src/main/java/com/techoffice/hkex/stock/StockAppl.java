package com.techoffice.hkex.stock;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.hkex.stock.crawler.StockCrawler;
import com.techoffice.hkex.stock.dao.StockDao;
import com.techoffice.hkex.stock.model.Stock;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

@Component
public class StockAppl {
	
	@Autowired
	private StockCrawler stockCrawler;
	
	@Autowired
	private StockDao stockDao;
	
	@Transactional
	public void run() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilDocumentConversionException{
		List<Stock> stocks = stockCrawler.retrieveStockList();
		for (Stock stock: stocks){
			if (stock.getStockCode() != null){
				System.out.println(stock.getStockCode() + " " + stock.getName());
				stockDao.save(stock);	
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilDocumentConversionException{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StockAppl appl = context.getBean(StockAppl.class);
		appl.run();
	}
}
