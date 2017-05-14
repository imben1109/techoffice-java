package com.techoffice.aastock.stock.crawler;

import org.springframework.stereotype.Service;

import com.techoffice.util.WebDriverUtil;

@Service
public class DividendCrawler {
	public static final String URL = "http://www.aastocks.com/tc/stocks/analysis/dividend.aspx?symbol=";
	
	public String getXml(String symbol){
		String xml = WebDriverUtil.getXml(URL + symbol);
		return xml;
	}
	
	
}
