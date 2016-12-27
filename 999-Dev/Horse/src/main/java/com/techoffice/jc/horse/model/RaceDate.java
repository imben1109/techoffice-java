package com.techoffice.jc.horse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="RACE_DATE")
public class RaceDate {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	
	@Column(name="RACE_DATE")
	private String raceDate;
	
	@Column(name="RACE_COUNT")
	private int raceCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaceDate() {
		return raceDate;
	}

	public void setRaceDate(String raceDate) {
		this.raceDate = raceDate;
	}

	public int getRaceCount() {
		return raceCount;
	}

	public void setRaceCount(int raceCount) {
		this.raceCount = raceCount;
	}
	
	
}
