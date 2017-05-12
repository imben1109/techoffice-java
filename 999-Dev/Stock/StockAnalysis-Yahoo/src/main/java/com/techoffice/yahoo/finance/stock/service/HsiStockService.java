package com.techoffice.yahoo.finance.stock.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.util.exception.XmlUtilInvalidDocumentException;
import com.techoffice.yahoo.finance.stock.crawler.HsiStockCrawler;
import com.techoffice.yahoo.finance.stock.crawler.PriceCrawler;
import com.techoffice.yahoo.finance.stock.dao.HsiDao;
import com.techoffice.yahoo.finance.stock.dao.HsiStockDao;
import com.techoffice.yahoo.finance.stock.model.Hsi;
import com.techoffice.yahoo.finance.stock.model.HsiStock;
import com.techoffice.yahoo.finance.stock.model.Price;

@Service
public class HsiStockService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static final String HSI = "%5EHSI";
	
	@Autowired
	private HsiStockCrawler hsiStockCrawler;
	
	@Autowired
	private PriceCrawler priceCrawler;

	@Autowired
	private HsiStockDao hsiStockDao;
	
	@Autowired
	private HsiDao hsiDao;
	
	@Transactional
	public void updateHsiStockList() throws XPathExpressionException, XmlUtilInvalidDocumentException {
		hsiStockDao.removeAll();
		List<HsiStock> hsiStockList = hsiStockCrawler.retrieveStockList();
		hsiStockDao.add(hsiStockList);
	}

	@Transactional
	public void updateHsi() throws IllegalAccessException, InvocationTargetException, IOException{
		hsiDao.removeAll();
		List<Price> prices = priceCrawler.retrieveHistoryPrice(HSI);
		List<Hsi> hsis = new ArrayList<Hsi>();
		for (Price price: prices){
			Hsi hsi = new Hsi();
			BeanUtils.copyProperties(price, hsi);
			hsis.add(hsi);
		}
		hsiDao.add(hsis);
	}
	
	@Transactional
	public List<HsiStock> list(){
		return hsiStockDao.list();
	}
	
}
