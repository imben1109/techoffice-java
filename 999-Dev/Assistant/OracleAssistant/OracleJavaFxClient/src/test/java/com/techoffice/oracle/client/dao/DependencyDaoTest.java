package com.techoffice.oracle.client.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.oracle.client.model.ParentTable;
import com.techoffice.oracle.client.model.RelationTable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class DependencyDaoTest {
	
	@Autowired
	private DependencyDao dependencyDao;
	
	@Test
	public void findAll(){
		List<RelationTable> results = dependencyDao.getRelationTableList();
		for(RelationTable dependentTable: results){
			System.out.println(dependentTable.getTableName());
		}
		
	}
}
