package com.techoffice.yahoo.finance.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	
	@Column(name="STOCK_NO")
	private String stockNo;
	
	@Column(name="CHI_NAME")
	private String chiName;
	
	
}
