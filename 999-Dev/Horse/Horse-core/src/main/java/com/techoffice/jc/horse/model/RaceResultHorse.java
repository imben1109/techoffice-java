package com.techoffice.jc.horse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="RACE_RESULT_HORSE")
public class RaceResultHorse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Version
	private int version;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="RACE_RESULT_ID")
	private RaceResult raceResult;
	
	@Column(name="PLACE")
	private String place;
	
	@Column(name="HORSE_NO")
	private String horseNo;
	
	@Column(name="HORSE_NAME")
	private String horseName;
	
	@Column(name="HORSE_ID")
	private String horseId;
	
	@Column(name="JOCKEY")
	private String jockey;
	
	@Column(name="TRAINER")
	private String trainer;
	
	@Column(name="ACTUAL_WT")
	private String actualWt;
	
	@Column(name="DECLARED_WT")
	private String declaredWt;
	
	@Column(name="DRAW")
	private String draw;
	
	@Column(name="LBW")
	private String lbw;
	
	@Column(name="RUNNING_POSITION")
	private String runningPosition;
	
	@Column(name="FINISH_TIME")
	private String FinishTime;
	
	@Column(name="WIN_ODDS")
	private String winOdds;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getHorseNo() {
		return horseNo;
	}
	public void setHorseNo(String horseNo) {
		this.horseNo = horseNo;
	}

	public String getHorseName() {
		return horseName;
	}
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	public String getHorseId() {
		return horseId;
	}
	public void setHorseId(String horseId) {
		this.horseId = horseId;
	}
	public String getJockey() {
		return jockey;
	}
	public void setJockey(String jockey) {
		this.jockey = jockey;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getActualWt() {
		return actualWt;
	}
	public void setActualWt(String actualWt) {
		this.actualWt = actualWt;
	}
	public String getDeclaredWt() {
		return declaredWt;
	}
	public void setDeclaredWt(String declaredWt) {
		this.declaredWt = declaredWt;
	}
	public String getDraw() {
		return draw;
	}
	public void setDraw(String draw) {
		this.draw = draw;
	}
	public String getLbw() {
		return lbw;
	}
	public void setLbw(String lbw) {
		this.lbw = lbw;
	}
	public String getRunningPosition() {
		return runningPosition;
	}
	public void setRunningPosition(String runningPosition) {
		this.runningPosition = runningPosition;
	}
	public String getFinishTime() {
		return FinishTime;
	}
	public void setFinishTime(String finishTime) {
		FinishTime = finishTime;
	}
	public String getWinOdds() {
		return winOdds;
	}
	public void setWinOdds(String winOdds) {
		this.winOdds = winOdds;
	}
	public RaceResult getRaceResult() {
		return raceResult;
	}
	public void setRaceResult(RaceResult raceResult) {
		this.raceResult = raceResult;
	}
	
	public boolean equal(RaceResultHorse toCompare){
		if (toCompare != null){
			if (toCompare.getId() == this.getId()){
				return true;
			}
		}
		return false;
	}
}
