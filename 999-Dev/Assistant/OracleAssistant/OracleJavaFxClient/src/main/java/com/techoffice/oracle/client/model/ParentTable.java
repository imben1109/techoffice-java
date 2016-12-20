package com.techoffice.oracle.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ParentTableKey.class)
public class ParentTable {
	
	@Id
	@Column(name="TABLE_NAME")
	private String tableName;
	
	@Id
	@Column(name="COLUMNS")
	private String columns;
	
	@Column(name="PARENT_TABLE")
	private String parentTable;
	
	@Column(name="PARENT_COLUMNS")
	private String parentTableColumns;

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getParentTable() {
		return parentTable;
	}
	public void setParentTable(String parentTable) {
		this.parentTable = parentTable;
	}
	public String getParentTableColumns() {
		return parentTableColumns;
	}
	public void setParentTableColumns(String parentTableColumns) {
		this.parentTableColumns = parentTableColumns;
	}
	public String getColumns() {
		return columns;
	}
	public void setColumns(String columns) {
		this.columns = columns;
	}

	
	
}
