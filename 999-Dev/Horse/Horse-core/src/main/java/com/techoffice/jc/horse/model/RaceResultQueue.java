package com.techoffice.jc.horse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="RACE_RESULT_QUEUE")
public class RaceResultQueue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="RACE_DATE")
	private Date raceDate;
	
	@Column(name="RACE_NUM")
	private String raceNum;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="RACE_TYPE")
	private String raceType;
	
	@Column(name="VENUE")
	private String venue;
	
	@Column(name="RUN_IND")
	private String runInd;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRunInd() {
		return runInd;
	}
	public void setRunInd(String runInd) {
		this.runInd = runInd;
	}
	public Date getRaceDate() {
		return raceDate;
	}
	public void setRaceDate(Date raceDate) {
		this.raceDate = raceDate;
	}
	public String getRaceNum() {
		return raceNum;
	}
	public void setRaceNum(String raceNum) {
		this.raceNum = raceNum;
	}
	public String getRaceType() {
		return raceType;
	}
	public void setRaceType(String raceType) {
		this.raceType = raceType;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
}
