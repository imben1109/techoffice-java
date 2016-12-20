package com.techoffice.oracle.client.model;

import java.io.Serializable;

public class ParentTableKey implements Serializable{
	private static final long serialVersionUID = -2416187500348182733L;
	
	private String tableName;
	
	private String columns;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	
	
}
