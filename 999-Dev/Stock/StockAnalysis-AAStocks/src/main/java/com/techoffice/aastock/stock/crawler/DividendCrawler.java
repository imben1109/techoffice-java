package com.techoffice.aastock.stock.crawler;

import org.springframework.stereotype.Service;

import com.techoffice.util.WebDriverUtil;

/**
 * A Web Crawler for 
 * http://www.aastocks.com/tc/stocks/analysis/dividend.aspx?symbol=
 * 
 * @author imben1109
 *
 */
@Service
public class DividendCrawler {
	public static final String URL = "http://www.aastocks.com/tc/stocks/analysis/dividend.aspx?symbol=";
	
	public static String getXml(String symbol){
		String xml = WebDriverUtil.getXml(URL + symbol);
		return xml;
	}
	
	public static void retrieve(String symbol){
		String xml = getXml(symbol);
	}
	
}
