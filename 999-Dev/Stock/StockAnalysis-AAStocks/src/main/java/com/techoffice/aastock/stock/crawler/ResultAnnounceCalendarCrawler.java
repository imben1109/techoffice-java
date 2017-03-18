package com.techoffice.aastock.stock.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Web Crawler for http://www.aastocks.com/en/stocks/market/calendar.aspx?type=1
 * @author imben1109
 *
 */
@Service
public class ResultAnnounceCalendarCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/calendar.aspx?type=1";
	
}
