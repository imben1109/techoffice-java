package com.techoffice.yahoo.finance.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * This model represents Stock in Hong Kong Hang Seng Index (HSI).
 * Stock in Hang Seng Index is Blue chip in Hong Kong.
 * 
 * @author ben
 *
 */
@Entity
@Table(name="HSI_STOCK")
public class HsiStock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="STOCK_NO")
	private String stockNo;
	
	@Column(name="CHI_NAME")
	private String chiName;

	public String getStockNo() {
		return stockNo;
	}

	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}

	public String getChiName() {
		return chiName;
	}

	public void setChiName(String chiName) {
		this.chiName = chiName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
