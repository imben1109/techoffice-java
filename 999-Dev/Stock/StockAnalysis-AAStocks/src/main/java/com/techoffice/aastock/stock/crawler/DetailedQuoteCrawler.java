package com.techoffice.aastock.stock.crawler;

import com.techoffice.util.WebDriverUtil;

/**
 * A Web Crawler for 
 * http://www.aastocks.com/tc/stocks/quote/detail-quote.aspx?symbol=
 * 
 * @author imben1109
 *
 */
public class DetailedQuoteCrawler {
	public static final String URL = "http://www.aastocks.com/tc/stocks/quote/detail-quote.aspx?symbol=";
	
	public String getXml(String symbol){
		String xml = WebDriverUtil.getXml(URL + symbol);
		return xml;
	}

}
