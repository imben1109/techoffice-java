package com.techoffice.oracle.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ChildTableKey.class)
public class ChildTable {
	
	@Id
	@Column(name="TABLE_NAME")
	private String tableName;
	
	@Id
	@Column(name="COLUMNS")
	private String columns;
	
	@Column(name="CHILD_TABLES")
	private String childTables;

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

	public String getChildTables() {
		return childTables;
	}

	public void setChildTables(String childTables) {
		this.childTables = childTables;
	}



	
	
}
