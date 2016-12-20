package com.techoffice.oracle.client.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.techoffice.oracle.client.model.DependentTable;

@Repository
public class DependencyDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<DependentTable> getDependentTableList(String tableName) {
		TypedQuery<DependentTable>  query = entityManager.createNamedQuery("Dependency.getDependentTables", DependentTable.class);
		query.setParameter("TABLE_NAME", tableName);
		List<DependentTable> results = query.getResultList();
		return results;
	}

}
