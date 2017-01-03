package com.techoffice.aastock.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Component
public class IndustryPerformanceCrawler {
	
	public static final String URL = "http://www.aastocks.com/tc/stocks/market/industry/industry-performance.aspx";
	
	@Autowired
	private WebClient webClient;
	
	public String retrieveXml() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		final HtmlPage page = webClient.getPage(URL);
		String xml = page.asXml();
		webClient.close();
		return xml;
	}
	
	public void getIndustryList() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		String xml = retrieveXml();
		
	}
}
