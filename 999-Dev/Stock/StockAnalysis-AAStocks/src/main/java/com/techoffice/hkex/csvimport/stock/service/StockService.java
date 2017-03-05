package com.techoffice.hkex.csvimport.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.hkex.csvimport.stock.dao.StockDao;
import com.techoffice.hkex.csvimport.stock.model.Stock;

/**
 * Stock Service 
 * 
 * @author imben1109
 *
 */
@Service
public class StockService {
	
	@Autowired
	private StockDao stockDao;
	
	public List<Stock> list(){
		return stockDao.list();
	}
}
