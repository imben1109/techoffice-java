package com.techoffice.etnet.news.dao;

import org.springframework.stereotype.Repository;

import com.techoffice.dao.BaseDao;
import com.techoffice.etnet.news.entity.News;

@Repository
public class NewsDao extends BaseDao<News>{

	@Override
	public Class<News> getEntityClass() {
		return News.class;
	}

	
	
	
}
