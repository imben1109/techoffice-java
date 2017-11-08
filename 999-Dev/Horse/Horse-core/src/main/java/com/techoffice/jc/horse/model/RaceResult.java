package com.techoffice.jc.horse.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="RACE_RESULT")
public class RaceResult {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Version
	private int version;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="RACE_DATE")
	private Date raceDate;
	
	@Column(name="VENUE")
	private String venue;
	
	@Column(name="RACE_NUM")
	private String raceNum;
	
	@Column(name="RACE_NO")
	private String raceNo;
	
	@Column(name="RACE_CLASS")
	private String raceClass;
	
	@Column(name="DISTANCE")
	private String distance;
	
	@Column(name="RTG_RANGE")
	private String rtgRange;
	
	@Column(name="GOING")
	private String going;
	
	@Column(name="RACE_NAME")
	private String raceName;
	
	@Column(name="COURSE")
	private String course;
	
	@Column(name="REWARD")
	private String reward;
	
	@Column(name="RACE_TIME")
	private String raceTime;
	
	@Column(name="SECTIONAL_TIME")
	private String sectionalTime;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="raceResult", cascade=CascadeType.ALL)
	private List<RaceResultHorse> raceResultHorseList;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public Date getRaceDate() {
		return raceDate;
	}
	public void setRaceDate(Date raceDate) {
		this.raceDate = raceDate;
	}
	public String getLocation() {
		return location;
	}
	public String getVenue(){
		return venue;
	}
	public void setVenue(String venue){
		this.venue = venue;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRaceNum() {
		return raceNum;
	}
	public void setRaceNum(String raceNum) {
		this.raceNum = raceNum;
	}
	public String getRaceNo() {
		return raceNo;
	}
	public void setRaceNo(String raceNo) {
		this.raceNo = raceNo;
	}
	public String getRaceClass() {
		return raceClass;
	}
	public void setRaceClass(String raceClass) {
		this.raceClass = raceClass;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getRtgRange() {
		return rtgRange;
	}
	public void setRtgRange(String rtgRange) {
		this.rtgRange = rtgRange;
	}
	public String getGoing() {
		return going;
	}
	public void setGoing(String going) {
		this.going = going;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getRaceTime() {
		return raceTime;
	}
	public void setRaceTime(String raceTime) {
		this.raceTime = raceTime;
	}
	public String getSectionalTime() {
		return sectionalTime;
	}
	public void setSectionalTime(String sectionalTime) {
		this.sectionalTime = sectionalTime;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public List<RaceResultHorse> getRaceResultHorseList() {
		return raceResultHorseList;
	}
	public void setRaceResultHorseList(List<RaceResultHorse> raceResultHorseList) {
		this.raceResultHorseList = raceResultHorseList;
	}
	
}
