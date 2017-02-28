package com.techoffice.aastock.stock.crawler;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import com.techoffice.util.exception.XmlUtilDocumentConversionException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class EarningSummaryCrawlerTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EarningSummaryCrawler earningSummaryCrawler;
	
//	@Test
	public void getYearList() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XmlUtilDocumentConversionException{
		earningSummaryCrawler.getYearList("00010");
	}
	
//	@Test
	public void getEarningPerShare() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XmlUtilDocumentConversionException{
		earningSummaryCrawler.getEarningPerShare("00010");
	}
	
	@Test
	public void test() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XmlUtilDocumentConversionException{
		earningSummaryCrawler.getDividendPerShare("00010");
	}
	
	
}
