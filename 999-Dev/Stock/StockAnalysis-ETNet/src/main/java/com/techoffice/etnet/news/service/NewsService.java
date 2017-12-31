package com.techoffice.etnet.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.etnet.news.dao.NewsDao;
import com.techoffice.etnet.news.entity.News;

@Service
public class NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Transactional
	public void add(List<News> newsList){
		for (News news: newsList){
			newsDao.add(news);
		}
	}
	
}
