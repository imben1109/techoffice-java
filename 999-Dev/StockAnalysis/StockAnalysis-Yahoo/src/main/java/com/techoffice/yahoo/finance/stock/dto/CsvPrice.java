package com.techoffice.yahoo.finance.stock.dto;

import java.util.Date;

import com.opencsv.bean.CsvBind;

public class CsvPrice {
	private String date;
	private double open;
	private double high;
	private double low;
	private double close;
	private double adjClose;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getAdjClose() {
		return adjClose;
	}
	public void setAdjClose(double adjClose) {
		this.adjClose = adjClose;
	}
	
}
