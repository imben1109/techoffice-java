package com.techoffice.oracle.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DependentTable {
	
	@Id
	@Column(name="TABLE_NAME")
	private String tableName;
	
	@Column(name="COLUMNS")
	private String columns;
	
	@Column(name="DEPENDENT_TABLE")
	private String dependentTable;
	
	@Column(name="DEPENDENT_COLUMNS")
	private String dependentColumns;

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getDependentTable() {
		return dependentTable;
	}
	public void setDependentTable(String dependentTable) {
		this.dependentTable = dependentTable;
	}
	public String getDependentColumns() {
		return dependentColumns;
	}
	public void setDependentColumns(String dependentColumns) {
		this.dependentColumns = dependentColumns;
	}
	public String getColumns() {
		return columns;
	}
	public void setColumns(String columns) {
		this.columns = columns;
	}

	
	
}
