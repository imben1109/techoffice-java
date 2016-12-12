package com.techoffice.aastock.stock.service.web;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.techoffice.util.XmlUtil;

@Service
public class CalendarWebService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/calendar.aspx";
	
	@Autowired
	private WebClient webClient;
	
	public String retrieveXmlFromWebClient() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		String xml = retrieveResultAnnounceXmlFromWebClient(null);
		return xml;
	}
	
	public String retrieveResultAnnounceXmlFromWebClient(String page) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
        HtmlPage htmlPage;
        if (page == null){
        	htmlPage = webClient.getPage(URL+"?type=1");
        }else {
        	htmlPage = webClient.getPage(URL + "?type=1&page=" + page);
        }
        String xml = htmlPage.asXml();
        webClient.close();
        return xml;
	}
	
	public void parseXml(String xml){
		String xPath = "/html/body/form/div[2]/div[6]/table[2]/tbody/tr";
	}
	
	public int getPageCount(String xml) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		String xPath = "/html/body/form/div[2]/div[6]/div[8]/table/tbody/tr/td[2]/a";
		NodeList tableNodeList = XmlUtil.evaluateXpath(xml, xPath);
		int pageCount = tableNodeList.getLength() + 1;
		return pageCount;
	}
}
