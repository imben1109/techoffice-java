package com.techoffice.etnet.news.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.etnet.news.dao.AvailableNewsDateDao;
import com.techoffice.etnet.news.dao.NewsDao;
import com.techoffice.etnet.news.entity.AvailableNewsDate;
import com.techoffice.etnet.news.entity.News;

@Service
public class ImmediateNewsService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private AvailableNewsDateDao availableNewsDateDao;
	
	@Autowired
	private ImmediateNewsCrawler immediateNewsCrawler;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveCrawledImmediateNewsListNewPropagation(AvailableNewsDate availableNewsDate){
		log.info("save crawled news: " + availableNewsDate.getDateStr() + " " + availableNewsDate.getUrl());
		availableNewsDate.setRunInd("Y");
		availableNewsDateDao.save(availableNewsDate);
		List<News> newsList = immediateNewsCrawler.getNewsList(availableNewsDate.getUrl());
		newsDao.add(newsList);
	}
	
}
