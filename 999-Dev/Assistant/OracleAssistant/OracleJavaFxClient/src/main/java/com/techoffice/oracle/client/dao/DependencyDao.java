package com.techoffice.oracle.client.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.techoffice.oracle.client.model.ParentTable;
import com.techoffice.oracle.client.model.RelationTable;

@Repository
public class DependencyDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<ParentTable> getDependentTableList(String tableName) {
		TypedQuery<ParentTable>  query = entityManager.createNamedQuery("Dependency.getDependentTables", ParentTable.class);
		query.setParameter("TABLE_NAME", tableName);
		List<ParentTable> results = query.getResultList();
		return results;
	}
	
	public List<RelationTable> getRelationTableList() {
		TypedQuery<RelationTable>  query = entityManager.createNamedQuery("Dependency.getRelationTables", RelationTable.class);
		List<RelationTable> results = query.getResultList();
		return results;
	}

}
