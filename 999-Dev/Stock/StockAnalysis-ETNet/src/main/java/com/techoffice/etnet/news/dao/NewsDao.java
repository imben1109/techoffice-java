package com.techoffice.etnet.news.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.techoffice.etnet.news.entity.News;

@Repository
public class NewsDao {

	@PersistenceContext
	private EntityManager em;
	
	public void add(News news){
		em.persist(news);
	}
	
	public void list(){
		em.createQuery("From News");
	}
}
