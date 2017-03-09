package com.techoffice.jc.horse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RACE_DATE")
public class RaceDate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="RACE_DATE")
	private String raceDate;
	
	@Column(name="RACE_COUNT")
	private int raceCount;
	
	@Column(name="RACE_TYPE")
	private String raceType;

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

	public String getRaceType() {
		return raceType;
	}

	public void setRaceType(String raceType) {
		this.raceType = raceType;
	}


	
	
}
