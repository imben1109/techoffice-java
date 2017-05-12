package com.techoffice.aastock.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.aastock.stock.model.IndustryDetail;

@Repository
public class IndustryDetailDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void add(List<IndustryDetail> list){
		for (IndustryDetail industryDetail: list){
			em.persist(industryDetail);
		}
	}
	
	@Transactional
	public List<IndustryDetail> list(String industrySymbol){
		TypedQuery<IndustryDetail> query = em.createQuery("From IndustryDetail Where IndustrySymbol = :industrySymbol", IndustryDetail.class);
		query.setParameter("industrySymbol", industrySymbol);
		return query.getResultList();
	}
	
	@Transactional
	public void deleteAll(String industrySymbol){
		Query query = em.createQuery("Delete from IndustryDetail Where IndustrySymbol = :industrySymbol");
		query.setParameter("industrySymbol", industrySymbol);
		query.executeUpdate();
	}
	
	
}
