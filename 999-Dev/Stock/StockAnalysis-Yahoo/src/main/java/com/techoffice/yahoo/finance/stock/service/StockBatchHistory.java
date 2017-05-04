package com.techoffice.yahoo.finance.stock.service;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class StockBatchHistory {
	
	@Id
	private String stockCode;
	private Date lastExecuted;
	
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public Date getLastExecuted() {
		return lastExecuted;
	}
	public void setLastExecuted(Date lastExecuted) {
		this.lastExecuted = lastExecuted;
	}
	
	
}
