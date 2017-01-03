package com.techoffice.aastock.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.aastock.stock.crawler.CalendarCrawler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class CalendarCrawlerTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CalendarCrawler calendarWebServiceTest;
	
	@Test
	public void retrieveStockListByWebClient() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		String xml = calendarWebServiceTest.retrieveXmlFromWebClient();
		int pageCount = calendarWebServiceTest.getPageCount(xml);
		log.info("Page Count: " + pageCount);
	}
}
