package com.techoffice.etnet.news.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.dao.BaseDao;
import com.techoffice.etnet.news.entity.News;

@Repository
public class NewsDao extends BaseDao<News>{

	@Override
	public Class<News> getEntityClass() {
		return News.class;
	}

	@Transactional
	public List<News> listByPostDate(Date postDate){
		return super.listByProperty("postDate", postDate);
	}
	
}
