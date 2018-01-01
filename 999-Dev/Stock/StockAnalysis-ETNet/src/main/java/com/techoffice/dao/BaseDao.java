package com.techoffice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class BaseDao<T> {

	@PersistenceContext
	private EntityManager em;
	
	public abstract Class<T> getEntityClass();
	
	public String getSimpleName(){
		return getEntityClass().getSimpleName();
	}
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	@Transactional
	public void persist(T entity){
		em.persist(entity);
	}

	@Transactional
	public T merge(T entity){
		return em.merge(entity);
	}

	@Transactional
	public void detact(T entity){
		em.detach(entity);
	}
	
	@Transactional
	public void add(List<T> entityList){
		for (T entity: entityList){
			add(entity);
		}
	}
	
	@Transactional
	public void add(T entity){
		em.persist(entity);
	}

	@Transactional
	public void save(T entity){
		entity = em.merge(entity);
	}
	
	@Transactional
	public void save(List<T> entityList){
		for (T entity: entityList){
			em.merge(entity);
		}
	}
	
	@Transactional
	public T find(Object primaryKey){
		return em.find(getEntityClass(), primaryKey);
	}
	
	@Transactional
	public List<T> list(){
		TypedQuery<T> typedQuery  = em.createQuery("FROM " + this.getSimpleName(), this.getEntityClass());
		return typedQuery.getResultList();
	}
	
	@Transactional
	public void delete(T entity){
		em.remove(entity);
	}
	
	@Transactional
	public void deleteByKey(Object primaryKey){
		T entity = find(primaryKey);
		delete(entity);
	}
	
	@Transactional
	public int deleteAll(){
		Query query = em.createQuery("DELETE FROM " + this.getSimpleName());
		return query.executeUpdate();
	}
	
	@Transactional
	public Long count(){
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(1) FROM " + this.getSimpleName(), Long.class);
		return query.getSingleResult();
	}
	
}
