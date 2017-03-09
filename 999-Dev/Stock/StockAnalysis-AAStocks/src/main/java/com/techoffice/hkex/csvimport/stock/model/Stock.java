package com.techoffice.hkex.csvimport.stock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Stock {
	
	@Id
	private String stockCode;
	private String name;
	private String chiName;
	
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChiName(){
		return chiName;
	}
	public void setChiName(String chiName){
		this.chiName = chiName;
	}
}
