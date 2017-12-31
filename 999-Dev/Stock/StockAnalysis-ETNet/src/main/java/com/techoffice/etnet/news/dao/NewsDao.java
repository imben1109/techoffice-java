package com.techoffice.etnet.news.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.etnet.news.entity.News;

@Repository
public class NewsDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void add(News news){
		em.persist(news);
	}
	
	@Transactional
	public void add(List<News> newsList){
		for (News news: newsList){
			em.persist(news);
		}
	}
	
	@Transactional
	public List<News> list(){
		TypedQuery<News> typedQuery  = em.createQuery("From News", News.class);
		return typedQuery.getResultList();
	}
	
	
	
	
}
