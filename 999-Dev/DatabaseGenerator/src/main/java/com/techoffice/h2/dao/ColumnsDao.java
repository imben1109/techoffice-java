package com.techoffice.h2.dao;

import java.util.List;

import com.techoffice.h2.model.Columns;
import com.techoffice.h2.util.H2DaoUtil;

public class ColumnsDao {
	
	public List<Columns> getColumnsList(String tableName) {
		return H2DaoUtil.list(Columns.class, "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "'");
	}
	
}
