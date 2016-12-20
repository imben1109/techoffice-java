package com.techoffice.oracle.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EntityTable {
	
	@Id
	@Column(name="TABLE_NAME")
	private String tableName;
	
	@Column(name="COLUMN_COUNT")
	private int columnCount;
	
	@Column(name="VIEW_IND")
	private String viewInd;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public String getViewInd() {
		return viewInd;
	}

	public void setViewInd(String viewInd) {
		this.viewInd = viewInd;
	}
	
	
	
}
