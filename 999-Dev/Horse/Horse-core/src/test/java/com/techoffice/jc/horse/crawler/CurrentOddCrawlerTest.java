package com.techoffice.jc.horse.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

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
import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.util.BeanUtil;
import com.techoffice.util.exception.DocumentConversionException;
import com.techoffice.util.exception.XpathException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class CurrentOddCrawlerTest {
	
	@Autowired
	private CurrentOddCrawler currentOddCrawler;
	
	@Autowired
	private HorseAdjTimeDao horseAdjTimeDao;
	
//	@Test
	public void getRaceNums() throws XpathException {
		currentOddCrawler.getRaceNums();		
	}
	
	@Test
	public void getHorse() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, DocumentConversionException, XpathException{
		List<CurrentOdd> currentOddList = currentOddCrawler.getCurrentOdd();
		for(CurrentOdd currentOdd: currentOddList){
			System.out.println(BeanUtil.toString(currentOdd));
		}
	}
	
//	@Test
	public void run() throws XPathExpressionException, DocumentConversionException, XpathException{
		currentOddCrawler.run();
	}
}
