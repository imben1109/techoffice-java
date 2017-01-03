package com.techoffice.aastock.stock.crawler;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.techoffice.factory.WebDriverFactory;
import com.techoffice.util.XmlUtil;

@Service
public class CalendarCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/calendar.aspx";
	
	public String retrieveXmlFromWebClient() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		File chromeDriverFile = new File("chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		String xml = driver.getPageSource();
		driver.quit();
		return xml;
	}
	
	public String retrieveResultAnnounceXmlFromWebClient(String page) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		WebDriver webDriver = WebDriverFactory.getWebDriver();
        if (page == null){
        	webDriver.get(URL+"?type=1");
        }else {
        	webDriver.get(URL + "?type=1&page=" + page);
        }
        String xml = webDriver.getPageSource();
        webDriver.quit();
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
