package com.techoffice.oracle.client.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.oracle.client.model.EntityTable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class EntityDaoTest {
	@Autowired
	private EntityDao entityDao;
	
	@Test
	public void getParentTableList(){
		List<EntityTable> results = entityDao.getParentTableList();
		for (EntityTable entityTable: results){
			System.out.println(entityTable.getTableName());
		}
	}
}
