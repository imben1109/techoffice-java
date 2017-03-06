package com.techoffice.hkex.csvimport.stock.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Stock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4536242756643954977L;
	
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
