package com.techoffice.etnet.news.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.dao.BaseDao;
import com.techoffice.etnet.news.entity.AvailableNewsDate;

@Repository
public class AvailableNewsDateDao extends BaseDao<AvailableNewsDate>{

	@Override
	public Class<AvailableNewsDate> getEntityClass() {
		return AvailableNewsDate.class;
	}

	@Transactional
	public List<AvailableNewsDate> listByRunInd(String runInd){
		TypedQuery<AvailableNewsDate> query = this.getEntityManager().createQuery(
				"FROM AvailableNewsDate WHERE runInd = :runInd", 
				AvailableNewsDate.class);
		query.setParameter("runInd", runInd);
		return query.getResultList();
	}
	
}
