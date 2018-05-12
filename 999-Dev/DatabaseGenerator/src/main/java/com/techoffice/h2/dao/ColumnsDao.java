package com.techoffice.h2.dao;

import java.util.List;

import com.techoffice.h2.model.Columns;
import com.techoffice.h2.util.DaoUtil;

public class ColumnsDao {
	
	public List<Columns> getColumnsList(String tableName) {
		return DaoUtil.list(Columns.class, "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "'");
	}
	
	public static void main(String[] args){
		ColumnsDao columnsDao = new ColumnsDao();
		List<Columns> columnsList = columnsDao.getColumnsList("TEST");
		for (Columns columns: columnsList){
			System.out.println(columns.getColumnName());
		}
	}
	
}
