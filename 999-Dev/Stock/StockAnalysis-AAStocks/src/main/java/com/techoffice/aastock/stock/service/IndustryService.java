package com.techoffice.aastock.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.aastock.stock.crawler.IndustryCrawler;
import com.techoffice.aastock.stock.dao.IndustryDao;
import com.techoffice.aastock.stock.model.Industry;
import com.techoffice.util.exception.WebCrawlerException;

@Service
public class IndustryService {
	
	@Autowired
	private IndustryCrawler industryCrawler;
	
	@Autowired
	private IndustryDao industryDao;
	
	@Transactional
	public List<Industry> list(){
		return industryDao.list();
	}
	
	@Transactional
	public void updateIndustry() throws WebCrawlerException{
		List<Industry> industries = industryCrawler.retrieveIndustryList();
		industryDao.clear();
		industryDao.add(industries);
	}
}
