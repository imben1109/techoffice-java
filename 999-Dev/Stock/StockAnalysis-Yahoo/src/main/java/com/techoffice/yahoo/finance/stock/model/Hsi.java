package com.techoffice.yahoo.finance.stock.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HSI")
@SequenceGenerator(name="HSI_SEQ")
public class Hsi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HSI_SEQ")
	private int id;

	@Column(name="PRICE_DATE")
	private Date priceDate;
	
	@Column(name="OPEN")
	private double open;
	
	@Column(name="HIGH")
	private double high;
	
	@Column(name="LOW")
	private double low;
	
	@Column(name="CLOSE")
	private double close;
	
	@Column(name="ADJ_CLOSE")
	private double adjClose;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
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
