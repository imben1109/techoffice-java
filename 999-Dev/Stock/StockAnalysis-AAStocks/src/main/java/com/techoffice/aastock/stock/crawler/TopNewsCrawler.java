package com.techoffice.aastock.stock.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.techoffice.util.WebDriverUtil;

@Component
public class TopNewsCrawler {
	
	public static final String URL = "http://www.aastocks.com/en/stocks/news/aafn/top-news";
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public void retrieve(){
		String xml = WebDriverUtil.getXmlScrollDown(URL);
		log.info(xml);
	}
}
