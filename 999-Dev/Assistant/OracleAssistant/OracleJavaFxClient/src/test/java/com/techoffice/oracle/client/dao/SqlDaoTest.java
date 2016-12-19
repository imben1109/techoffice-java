package com.techoffice.oracle.client.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class SqlDaoTest {
	
	@Autowired
	private SqlDao sqlDao;
	
	@Test
	public void selectTableList(){
		List<String> tableList = sqlDao.selectTableList();
		for (String table: tableList){
			System.out.println(table);
		}
	}
}
