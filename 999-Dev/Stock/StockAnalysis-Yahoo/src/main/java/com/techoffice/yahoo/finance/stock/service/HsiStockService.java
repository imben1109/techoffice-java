package com.techoffice.yahoo.finance.stock.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.yahoo.finance.stock.crawler.HsiStockCrawler;
import com.techoffice.yahoo.finance.stock.dao.HsiStockDao;
import com.techoffice.yahoo.finance.stock.model.HsiStock;

@Service
public class HsiStockService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HsiStockCrawler hsiStockCrawler;

	@Autowired
	private HsiStockDao hsiStockDao;
	
	@Transactional
	public void updateHsiStockList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		hsiStockDao.removeAll();
		List<HsiStock> hsiStockList = hsiStockCrawler.retrieveStockList();
		hsiStockDao.add(hsiStockList);
	}
	
	@Transactional
	public List<HsiStock> list(){
		return hsiStockDao.list();
	}
	
}
