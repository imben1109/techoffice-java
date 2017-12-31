package com.techoffice.etnet.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.etnet.news.dao.NewsDao;

@Service
public class ImmediateNewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private ImmediateNewsCrawler ImmediateNewsCrawler;
	
	
}
