package com.techoffice.aastock.stock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.aastock.stock.crawler.IndustryDetailCrawler;
import com.techoffice.aastock.stock.dao.IndustryDetailDao;
import com.techoffice.aastock.stock.model.IndustryDetail;
import com.techoffice.util.exception.WebCrawlerException;

@Service
public class IndustryDetailService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IndustryDetailCrawler industryDetailCrawler;
	
	@Autowired
	private IndustryDetailDao industryDetailDao;
	
	@Transactional
	public List<IndustryDetail> list(String industrySymbol){
		return industryDetailDao.list(industrySymbol);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateIndustryDetail(String industrySymbol) throws WebCrawlerException{
		log.info("Start to update Industry Symbol: " + industrySymbol);
		industryDetailDao.deleteAll(industrySymbol);
		List<IndustryDetail> industryDetails = industryDetailCrawler.retrieve(industrySymbol);
		industryDetailDao.add(industryDetails);
		log.info("Complete to update Industry Symbol: " + industrySymbol);
	}
}
