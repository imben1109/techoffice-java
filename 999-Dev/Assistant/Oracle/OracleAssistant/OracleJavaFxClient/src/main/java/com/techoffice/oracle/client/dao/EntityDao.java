package com.techoffice.oracle.client.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.techoffice.oracle.client.model.EntityTable;

@Repository
public class EntityDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<EntityTable> getEntityTableList() {
		TypedQuery<EntityTable>  query = entityManager.createNamedQuery("Entity.getEntityTables", EntityTable.class);
		List<EntityTable> results = query.getResultList();
		return results;
	}
	
}
