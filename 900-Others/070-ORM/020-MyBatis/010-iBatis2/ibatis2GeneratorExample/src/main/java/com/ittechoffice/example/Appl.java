package com.ittechoffice.example;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;
import com.ittechoffice.example.dao.Table1DAO;
import com.ittechoffice.example.model.Table1;
import com.ittechoffice.example.model.Table1Example;

public class Appl {
	public static void main(String[] args) throws IOException {
	    Reader rd = Resources.getResourceAsReader("dao-config.xml");
	    DaoManager daoManager = DaoManagerBuilder.buildDaoManager(rd);
	    Table1DAO table1DAO = (Table1DAO) daoManager.getDao(Table1DAO.class);
	    
	    try {
	    	// Insert Data
	    	daoManager.startTransaction();
	    	Table1 sample = new Table1();
	    	sample.setCol1("Test");
	    	table1DAO.insert(sample);
	    }finally{
	    	daoManager.endTransaction();
	    }
	    
	    // Select Data and print num count
    	List<Table1> list = table1DAO.selectByExample(new Table1Example());
    	System.out.println(list.size());

	    
	}
}
