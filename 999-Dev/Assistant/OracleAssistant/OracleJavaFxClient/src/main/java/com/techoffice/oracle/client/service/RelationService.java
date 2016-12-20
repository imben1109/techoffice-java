package com.techoffice.oracle.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.client.dao.RelationDao;
import com.techoffice.oracle.client.dao.TableDao;
import com.techoffice.oracle.client.model.ChildTable;
import com.techoffice.oracle.client.model.ParentTable;
import com.techoffice.oracle.client.model.RelationTable;

@Service
public class RelationService {
	
	@Autowired
	private TableDao userTableDao;
	
	@Autowired
	private RelationDao relationDao;
	
	public List<String> selectTableList(){
		return userTableDao.selectTableList();
	}
	
	public List<ParentTable> getParentTableList(String tableName){
		return relationDao.getParentTableList(tableName);
	}
	
	public List<ChildTable> getChildTableList(String tableName){
		return relationDao.getChildTableList(tableName);
	}
	
	public List<RelationTable> getRelationTableList(){
		return relationDao.getRelationTableList();

	}
}
