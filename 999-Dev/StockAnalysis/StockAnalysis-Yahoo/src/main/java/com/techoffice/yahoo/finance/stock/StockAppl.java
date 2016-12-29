package com.techoffice.yahoo.finance.stock;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import com.techoffice.yahoo.finance.stock.crawler.StockHistoryDataCrawler;
import com.techoffice.yahoo.finance.stock.dao.StockDao;
import com.techoffice.yahoo.finance.stock.model.Price;

@Component
public class StockAppl {
	
	@Autowired
	private StockHistoryDataCrawler stockHistoryDataCrawler;
	
	@Autowired
	private StockDao stockDao;
	
	public void run() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, IllegalAccessException, InvocationTargetException{
//		List<Price> prices =stockHistoryDataCrawler.retrieveHistoryPriceData("0939");
//		stockDao.addPriceList(prices);
		List<Price> prices = stockDao.getPriceList();
		for(Price price: prices){
			System.out.println(price.getAdjClose());
		}
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, IllegalAccessException, InvocationTargetException{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StockAppl appl = context.getBean(StockAppl.class);
		appl.run();
	}
}
