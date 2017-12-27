package com.techoffice.etnet.stock.realtime.crawler;

import org.springframework.stereotype.Component;

import com.techoffice.util.WebDriverUtil;

/**
 * 
 * http://www.etnet.com.hk/www/tc/stocks/realtime/quote_super.php?code=
 * 
 * @author TechOffice
 *
 */
@Component
public class RealTimeStockCrawler {
	public static final String URL = "http://www.etnet.com.hk/www/tc/stocks/realtime/quote_super.php?code=";
	
	public String retrieveXmlByCode(String code) {
		String xml = WebDriverUtil.getXml(URL+code);
        return xml;
	}
	
}
