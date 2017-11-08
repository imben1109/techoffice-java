package com.techoffice.aastock.boot;

import org.springframework.boot.SpringApplication;

import com.techoffice.aastock.boot.config.Config;

public class StockAnalysisAAStockAppl {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Config.class, args);
    }
    
}
