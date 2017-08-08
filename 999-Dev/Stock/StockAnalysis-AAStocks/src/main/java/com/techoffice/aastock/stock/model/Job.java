package com.techoffice.aastock.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Job {
	
	public enum Status {PENDING, COMPLETED, FAIL}
	
	@Id
	@SequenceGenerator(name="JOB_SEQ", sequenceName="JOB_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_SEQ")
	private int id;
	private String className;
	private Status status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Status getStatus(){
		return status;
	}
	public void setStatus(Status status){
		this.status = status;
	}
	
}
