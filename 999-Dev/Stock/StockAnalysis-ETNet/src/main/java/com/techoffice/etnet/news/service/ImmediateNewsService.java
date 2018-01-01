package com.techoffice.etnet.news.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.etnet.news.dao.NewsDao;
import com.techoffice.etnet.news.entity.AvailableNewsDate;
import com.techoffice.etnet.news.entity.News;

@Service
public class ImmediateNewsService {

	@Autowired
	private NewsDao newsDao;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ImmediateNewsCrawler immediateNewsCrawler;
	
	public void addCrawledImmediateNewsList(){
		List<AvailableNewsDate> availableNewsDateList = immediateNewsCrawler.getAvailableDateList();
		log.info("No. of Available Date List: " + availableNewsDateList.size());
		Assert.isTrue(availableNewsDateList.size() > 0);
		for (AvailableNewsDate availableNewsDate: availableNewsDateList){
			List<News> newsList = immediateNewsCrawler.getNewsList(availableNewsDate.getUrl());
			log.info(availableNewsDate.getUrl() + " Total News Number: " + newsList.size());
			newsDao.add(newsList);
		}
	}
	
}
