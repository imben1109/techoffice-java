package com.techoffice.oracle.client.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.oracle.client.model.DependentTable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class DependencyDaoTest {
	
	@Autowired
	private DependencyDao dependencyDao;
	
	@Test
	public void findAll(){
		try{
		List<DependentTable> results = dependencyDao.getDependentTableList("X_GEQ_GOVT_ENQ");
		for(DependentTable dependentTable: results){
			System.out.println(dependentTable.getTableName());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
