package com.techoffice.aastock.stock.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INDUSTRY_DETAIL")
public class IndustryDetail {
	
	@Id
	@SequenceGenerator(name="INDUSTRY_DETAIL_SEQ", sequenceName="INDUSTRY_DETAIL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INDUSTRY_DETAIL_SEQ")
	private int id;
	private String industrySymbol;
	private String name;
	private String symbol;
	private Date lastUpdated;
	private double last;
	private String chg;
	private String pctChg;
	private String volume;
	private String turnover;
	private String pe;
	private String pb;
	private String yeild;
	private String marketCap;
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
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public double getLast() {
		return last;
	}
	public void setLast(double last) {
		this.last = last;
	}
	public String getChg() {
		return chg;
	}
	public void setChg(String chg) {
		this.chg = chg;
	}
	public String getPctChg() {
		return pctChg;
	}
	public void setPctChg(String pctChg) {
		this.pctChg = pctChg;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getPe() {
		return pe;
	}
	public void setPe(String pe) {
		this.pe = pe;
	}
	public String getPb() {
		return pb;
	}
	public void setPb(String pb) {
		this.pb = pb;
	}
	public String getYeild() {
		return yeild;
	}
	public void setYeild(String yeild) {
		this.yeild = yeild;
	}
	public String getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}
	public String getIndustrySymbol() {
		return industrySymbol;
	}
	public void setIndustrySymbol(String industrySymbol) {
		this.industrySymbol = industrySymbol;
	}
	
	
}
