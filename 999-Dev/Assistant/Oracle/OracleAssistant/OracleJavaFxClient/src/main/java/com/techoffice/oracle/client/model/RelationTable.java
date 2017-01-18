package com.techoffice.oracle.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RelationTable {
	
	@Id	
	@Column(name="TABLE_NAME")
	private String tableName;
	
	@Column(name="PARENT_TABLE_COUNT")
	private int parentTableCount;
	
	@Column(name="CHILD_TABLE_COUNT")
	private int childTableCount;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getParentTableCount() {
		return parentTableCount;
	}

	public void setParentTableCount(int parentTableCount) {
		this.parentTableCount = parentTableCount;
	}

	public int getChildTableCount() {
		return childTableCount;
	}

	public void setChildTableCount(int childTableCount) {
		this.childTableCount = childTableCount;
	}
	
	
}
