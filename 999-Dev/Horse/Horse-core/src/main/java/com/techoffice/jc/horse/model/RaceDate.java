package com.techoffice.jc.horse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="RACE_DATE")
public class RaceDate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Version
	private int version;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="RACE_COUNT")
	private int raceCount;
	
	@Column(name="RACE_TYPE")
	private String raceType;

	@Column(name="RACE_DATE")
	private Date raceDate;
	
	@Column(name="VENUE")
	private String venue;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getRaceDate() {
		return raceDate;
	}

	public void setRaceDate(Date raceDate) {
		this.raceDate = raceDate;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	
}
