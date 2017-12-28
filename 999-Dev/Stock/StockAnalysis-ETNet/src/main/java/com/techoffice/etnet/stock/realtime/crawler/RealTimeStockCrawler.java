package com.techoffice.etnet.stock.realtime.crawler;

import org.springframework.stereotype.Component;

import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

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
		String xml = WebDriverUtil.getXml(URL + code);
        return xml;
	}
	
	public String getCurrentPrice(String code){
		final String xpath = "/html/body/div/div[5]/table[1]/tbody/tr[2]/td[1]/ul/li[2]";
		String xml = this.retrieveXmlByCode(code);
		String currentPrice = XmlUtil.getXpathText(xml, xpath);
		return currentPrice;
	}
}
