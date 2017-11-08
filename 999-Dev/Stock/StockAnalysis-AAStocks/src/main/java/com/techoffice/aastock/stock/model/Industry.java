package com.techoffice.aastock.stock.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Industry {
	
	@Id
    @SequenceGenerator(name="industry_seq",sequenceName="industry_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="industry_seq")
	private int id;
	private String name;
	private String industrySymbol;
	private Date updated;
	private String chgPct;
	private String prevChgPct;
	private String turn;
	private String avgTurn5d;
	private String avgPe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustrySymbol() {
		return industrySymbol;
	}

	public void setIndustrySymbol(String industrySymbol) {
		this.industrySymbol = industrySymbol;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}



	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getAvgTurn5d() {
		return avgTurn5d;
	}

	public void setAvgTurn5d(String avgTurn5d) {
		this.avgTurn5d = avgTurn5d;
	}

	public String getChgPct() {
		return chgPct;
	}

	public void setChgPct(String chgPct) {
		this.chgPct = chgPct;
	}

	public String getPrevChgPct() {
		return prevChgPct;
	}

	public void setPrevChgPct(String prevChgPct) {
		this.prevChgPct = prevChgPct;
	}

	public String getAvgPe() {
		return avgPe;
	}

	public void setAvgPe(String avgPe) {
		this.avgPe = avgPe;
	}


}
