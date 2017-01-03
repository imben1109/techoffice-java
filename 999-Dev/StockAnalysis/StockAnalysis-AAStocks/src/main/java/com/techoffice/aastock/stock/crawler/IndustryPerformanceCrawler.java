package com.techoffice.aastock.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.techoffice.factory.WebDriverFactory;
import com.techoffice.util.XmlUtil;

@Component
public class IndustryPerformanceCrawler {
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/industry/industry-performance.aspx";
		
	public String retrieveXml() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		WebDriver webDriver = WebDriverFactory.getWebDriver();
		webDriver.get(URL);
		String xml = webDriver.getPageSource();
		webDriver.quit();
		return xml;
	}
	
	public void retrieveIndustryList() throws FailingHttpStatusCodeException, MalformedURLException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		String xml = retrieveXml();
		String xPath = "//*[@id='IndustyMain']/div[6]/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/a";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xPath);
		System.out.println("No of Row: " + rowNodeList.getLength());
		for (int i=0; i<rowNodeList.getLength(); i++){
			Node industryNode = rowNodeList.item(i);
			String industryName = industryNode.getTextContent();
			System.out.println(industryName);
		}
	}
}
