package com.techoffice.aastock.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class IndustryPerformanceCrawlerTest {
	
	@Autowired
	private IndustryPerformanceCrawler industryPerformanceCrawler;
	
	@Test
	public void getIndrustryList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, XmlUtilDocumentConversionException{
		List<String> industryList = industryPerformanceCrawler.retrieveIndustryList();
		for(String industry: industryList){
			System.out.println(industry);
		}
	}
}
