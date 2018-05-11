package com.techoffice.h2.dao;

import java.util.List;

import com.techoffice.h2.model.Columns;
import com.techoffice.h2.util.DaoUtil;

public class ColumnsDao {
	
	public static List<Columns> GetColumnsList(String tableName) {
		return DaoUtil.list(Columns.class, "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "'");
	}
	
	public static void main(String[] args){
		List<Columns> columnsList = GetColumnsList("COLUMNS");
		for (Columns columns: columnsList){
			System.out.println(columns.getColumnName());
		}
	}
	
}
