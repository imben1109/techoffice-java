package com.techoffice.aastock.stock.market.service.webclient;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Service
public class CalendarWebService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/calendar.aspx?type=1";
	
	@Autowired
	private WebClient webClient;
	
	public String retrieveXmlFromWebClient() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		String xml = retrieveXmlFromWebClient(null);
		return xml;
	}
	
	public String retrieveXmlFromWebClient(String page) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
        HtmlPage htmlPage;
        if (page == null){
        	htmlPage = webClient.getPage(URL);
        }else {
        	htmlPage = webClient.getPage(URL + "&page=" + page);
        }
        String xml = htmlPage.asXml();
        webClient.close();
        return xml;
	}
}
