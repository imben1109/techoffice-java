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
	
}
