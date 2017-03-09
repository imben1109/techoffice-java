package com.techoffice.oracle.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.client.dao.EntityDao;
import com.techoffice.oracle.client.dao.TableDao;
import com.techoffice.oracle.client.model.Column;
import com.techoffice.oracle.client.model.EntityTable;

@Service
public class EntityService {
	
	@Autowired
	private EntityDao entityDao;
	
	@Autowired
	private TableDao tableDao;
	
	public List<EntityTable> getEntityTableList() {
		return entityDao.getEntityTableList();
	} 
	
	public List<Column> getTableColumnList(String tableName){
		return tableDao.getTableColumnList(tableName);
	}
}
