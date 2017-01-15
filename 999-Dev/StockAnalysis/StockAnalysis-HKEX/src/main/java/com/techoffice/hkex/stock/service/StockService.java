package com.techoffice.hkex.stock.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.hkex.stock.crawler.StockCrawler;
import com.techoffice.hkex.stock.dao.StockDao;
import com.techoffice.hkex.stock.model.Stock;

@Service
public class StockService {
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private StockCrawler stockWebClientService;
	
	public List<Stock> getStockList(){
		return stockDao.list();
	}
	
	public void clearStockList(){
		stockDao.clear();
	}
	
	@Transactional
	public void updateFromInternet() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		stockDao.clear();
		List<Stock> stockList = stockWebClientService.retrieveStockListByWebClient();
		for(Stock stock: stockList){
			if (stock.getStockCode() != null){
				stockDao.save(stock);	
			}
		}
	}
}
