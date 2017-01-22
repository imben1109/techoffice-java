package com.techoffice.jc.horse.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.jc.horse.dao.HorseAdjTimeDao;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class CurrentOddsCrawlerTest {
	
	@Autowired
	private CurrentOddsCrawler currentOddsCrawler;
	
	@Autowired
	private HorseAdjTimeDao horseAdjTimeDao;
	
//	@Test
	public void getRaceNums() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilDocumentConversionException{
		currentOddsCrawler.getRaceNums();		
	}
	
	@Test
	public void getHorse() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		currentOddsCrawler.getCurrent();
	}
}
