package com.techoffice.oracle.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.client.dao.RelationDao;
import com.techoffice.oracle.client.dao.UserTableDao;
import com.techoffice.oracle.client.model.ChildTable;
import com.techoffice.oracle.client.model.ParentTable;
import com.techoffice.oracle.client.model.RelationTable;

@Service
public class UserTableService {
	
	@Autowired
	private UserTableDao userTableDao;
	
	@Autowired
	private RelationDao dependencyDao;
	
	public List<String> selectTableList(){
		return userTableDao.selectTableList();
	}
	
	public List<ParentTable> getParentTableList(String tableName){
		return dependencyDao.getParentTableList(tableName);
	}
	
	public List<ChildTable> getChildTableList(String tableName){
		return dependencyDao.getChildTableList(tableName);
	}
	
	public List<RelationTable> getRelationTableList(){
		return dependencyDao.getRelationTableList();

	}
}
