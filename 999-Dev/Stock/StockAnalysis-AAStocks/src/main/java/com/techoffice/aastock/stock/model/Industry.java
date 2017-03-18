package com.techoffice.aastock.stock.model;

import java.util.Date;

public class Industry {
	private String name;
	private String industrySymbol;
	private Date updated;
	private String chgPct;
	private String prevChgPct;
	private String turn;
	private String avgTurn5d;
	private String avgPe;

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
