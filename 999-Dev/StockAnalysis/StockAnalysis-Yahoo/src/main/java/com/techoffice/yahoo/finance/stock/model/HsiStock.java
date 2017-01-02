package com.techoffice.yahoo.finance.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This model represents Stock in Hong Kong Hang Seng Index (HSI).
 * 
 * @author ben
 *
 */
@Entity
@Table(name="HKSE_STOCK")
public class HsiStock {
	
	@Column(name="STOCK_NO")
	private String stockNo;
	
	@Column(name="NAME")
	private String name;
	
	
}
