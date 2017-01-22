package com.techoffice.jc.horse.dto;

public class CurrentOdd implements Comparable<CurrentOdd>{
	private String horseName;
	private String draw;
	private Double adjTime;
	private Double drawTime;
	private Double calcTime; 
	public String getHorseName() {
		return horseName;
	}
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	public Double getDrawTime() {
		return drawTime;
	}
	public void setDrawTime(Double drawTime) {
		this.drawTime = drawTime;
	}
	public String getDraw() {
		return draw;
	}
	public void setDraw(String draw) {
		this.draw = draw;
	}
	public Double getAdjTime() {
		return adjTime;
	}
	public void setAdjTime(Double adjTime) {
		this.adjTime = adjTime;
	}
	public Double getCalcTime() {
		return calcTime;
	}
	public void setCalcTime(Double calcTime) {
		this.calcTime = calcTime;
	}
	public int compareTo(CurrentOdd that) {
		if (that.getAdjTime() != null && this.getAdjTime() != null){
			if (this.getAdjTime() > that.getAdjTime()){
				return 1;
			}
			if (this.getAdjTime() < that.getAdjTime()){
				return -1;
			}
			if (this.getAdjTime() == that.getAdjTime()){
				return 0;
			}
		}
		if (that.getAdjTime() == null){
			return 1;
		}
		if (this.getAdjTime() == null){
			return -1;
		}
		return 1;
	}
	
	
}
