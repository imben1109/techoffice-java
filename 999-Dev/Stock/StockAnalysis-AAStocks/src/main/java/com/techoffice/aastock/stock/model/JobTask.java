package com.techoffice.aastock.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class JobTask {
	
	public enum Status {PENDING, COMPLETED, FAIL}
	
	@Id
	@SequenceGenerator(name="TASK_SEQ", sequenceName="TASK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASK_SEQ")
	private int id;
	private int jobId;
	private String taskName;
	private Status status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
