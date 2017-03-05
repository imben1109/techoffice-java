package com.techoffice.aastock.stock.model;

import java.util.Date;

public class ResultAnnounceCalendar {
	private Date calendarDate;
	private String code;
	private String stockName;
	private String industry;
	private String period;
	public Date getCalendarDate() {
		return calendarDate;
	}
	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
	
}
