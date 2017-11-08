package com.techoffice.aastock.stock.model;

import java.util.Date;

public class Dividend {
	private Date announceDate;
	private Date yearEnd;
	private String event;
	private String particular;
	private String type;
	private Date exDate;
	private Date bookCloseDate;
	private Date payableDate;
	public Date getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(Date announceDate) {
		this.announceDate = announceDate;
	}
	public Date getYearEnd() {
		return yearEnd;
	}
	public void setYearEnd(Date yearEnd) {
		this.yearEnd = yearEnd;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getExDate() {
		return exDate;
	}
	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}
	public Date getBookCloseDate() {
		return bookCloseDate;
	}
	public void setBookCloseDate(Date bookCloseDate) {
		this.bookCloseDate = bookCloseDate;
	}
	public Date getPayableDate() {
		return payableDate;
	}
	public void setPayableDate(Date payableDate) {
		this.payableDate = payableDate;
	}
	
	
}
