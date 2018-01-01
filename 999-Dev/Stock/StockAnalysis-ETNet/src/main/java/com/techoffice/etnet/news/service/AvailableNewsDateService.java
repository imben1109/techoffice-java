package com.techoffice.etnet.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.etnet.news.dao.AvailableNewsDateDao;
import com.techoffice.etnet.news.entity.AvailableNewsDate;

@Service
public class AvailableNewsDateService {

	@Autowired
	private ImmediateNewsCrawler immediateNewsCrawler;
	
	@Autowired
	private AvailableNewsDateDao availableNewsDateDao;
	
	@Transactional
	public void saveCrawledAvailableDateList(){
		 List<AvailableNewsDate> availableNewsDateList =  immediateNewsCrawler.getAvailableDateList();
		 availableNewsDateDao.save(availableNewsDateList);
	}
}
