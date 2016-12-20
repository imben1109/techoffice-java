package com.techoffice.oracle.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.client.dao.DependencyDao;
import com.techoffice.oracle.client.dao.UserTableDao;
import com.techoffice.oracle.client.model.ParentTable;
import com.techoffice.oracle.client.model.RelationTable;

@Service
public class UserTableService {
	
	@Autowired
	private UserTableDao userTableDao;
	
	@Autowired
	private DependencyDao dependencyDao;
	
	public List<String> selectTableList(){
		return userTableDao.selectTableList();
	}
	
	public List<ParentTable> getDependentTableList(String tableName){
		return dependencyDao.getDependentTableList(tableName);
	}
	
	public List<RelationTable> getRelationTableList(){
		return dependencyDao.getRelationTableList();

	}
}
