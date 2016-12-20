package com.techoffice.oracle.client.model;

import java.io.Serializable;

public class ChildTableKey implements Serializable{

	private static final long serialVersionUID = 4356716226293125096L;
	
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
