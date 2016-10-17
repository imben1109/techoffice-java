package com.ittechoffice.webcrawl.fap.hkex.stock;

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
import com.ittechoffice.webcrawl.fap.hkex.stock.dao.StockDao;
import com.ittechoffice.webcrawl.fap.hkex.stock.model.Stock;

@Component
public class StockAppl {
	
	@Autowired
	private StockListWeb stockListWeb;
	
	@Autowired
	private StockDao stockDao;
	
	@Transactional
	public void run() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		List<Stock> stocks = stockListWeb.retrieveStockListByWebClient();
		for (Stock stock: stocks){
			if (stock.getStockCode() != null){
				System.out.println(stock.getStockCode());
				stockDao.save(stock);	
			}
		}
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StockAppl appl = context.getBean(StockAppl.class);
		appl.run();
	}
}
