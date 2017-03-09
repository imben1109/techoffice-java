package com.techoffice.oracle.client.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.techoffice.oracle.client.model.ChildTable;
import com.techoffice.oracle.client.model.ParentTable;
import com.techoffice.oracle.client.model.RelationTable;

@Repository
public class RelationDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<ParentTable> getParentTableList(String tableName) {
		TypedQuery<ParentTable>  query = entityManager.createNamedQuery("Relation.getParentTables", ParentTable.class);
		query.setParameter("TABLE_NAME", tableName);
		List<ParentTable> results = query.getResultList();
		return results;
	}
	
	public List<RelationTable> getRelationTableList() {
		TypedQuery<RelationTable>  query = entityManager.createNamedQuery("Relation.getRelationTables", RelationTable.class);
		List<RelationTable> results = query.getResultList();
		return results;
	}
	
	public List<ChildTable> getChildTableList(String tableName) {
		TypedQuery<ChildTable>  query = entityManager.createNamedQuery("Relation.getChildTables", ChildTable.class);
		query.setParameter("TABLE_NAME", tableName);
		List<ChildTable> results = query.getResultList();
		return results;
	}

}
