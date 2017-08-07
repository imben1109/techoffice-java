package com.techoffice.aastock.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Job {
	
	@Id
	@SequenceGenerator(name="JOB_SEQ", sequenceName="JOB_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_SEQ")
	private int id;
	private String tableName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	
}
