package com.techoffice.database.h2.dao;

import java.util.List;

import com.techoffice.database.h2.model.Columns;
import com.techoffice.database.h2.util.H2DaoUtil;

public class ColumnsDao {
	
	private ColumnsDao(){}
	
	private static ColumnsDao instance =  new ColumnsDao();
	
	public static ColumnsDao getInstance(){
		return instance;
	}
	
	public List<Columns> getColumnsList(String tableName) {
		return H2DaoUtil.list(Columns.class, ColumnsDao.class, 
				"SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "'");
	}
	
	public static void main(String[] args){
		ColumnsDao columnsDao = new ColumnsDao();
		List<Columns> columnsList = columnsDao.getColumnsList("TEST");
		for (Columns columns: columnsList){
			System.out.println(columns.getColumnName());
		}
	}
	
}
