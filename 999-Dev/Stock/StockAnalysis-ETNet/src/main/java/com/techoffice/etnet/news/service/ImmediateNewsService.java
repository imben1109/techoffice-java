package com.techoffice.etnet.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.etnet.news.dao.NewsDao;
import com.techoffice.etnet.news.entity.News;
import com.techoffice.etnet.news.model.AvailableNewsDate;

@Service
public class ImmediateNewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private ImmediateNewsCrawler immediateNewsCrawler;
	
	public void addCrawledImmediateNewsList(){
		List<AvailableNewsDate> availableNewsDateList = immediateNewsCrawler.getAvailableDateList();
		for (AvailableNewsDate availableNewsDate: availableNewsDateList){
			List<News> newsList = immediateNewsCrawler.getNewsList(availableNewsDate.getUrl());
			newsDao.add(newsList);
		}
	}
	
}
