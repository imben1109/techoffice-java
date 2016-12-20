package com.techoffice.oracle.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.client.dao.EntityDao;
import com.techoffice.oracle.client.model.EntityTable;

@Service
public class EntityService {
	
	@Autowired
	private EntityDao entityDao;
	
	public List<EntityTable> getParentTableList() {
		return entityDao.getParentTableList();
	} 
}
