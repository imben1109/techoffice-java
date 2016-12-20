package com.techoffice.jc.horse.service.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

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
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class ResultWebServiceTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResultWebService resultWebService;

//	@Test
	public void retrieveXml() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		String xml = resultWebService.retrieveXml();
		System.out.println(xml);	
	}
	
//	@Test
	public void retrieveRaceDateList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		List<String> raceDateList = resultWebService.retrieveRaceDateList();
		for(String raceDate: raceDateList){
			System.out.println(raceDate);
		}
	}
	
//	@Test
	public void getRaceNumList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		List<String> raceDateList = resultWebService.retrieveRaceDateList();
		List<String> raceNumList = resultWebService.getRaceNumList(raceDateList.get(0));
		for(String raceNum: raceNumList){
			System.out.println(raceNum);
		}
	}
	
	@Test
	public void getRaceResult() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilXpathNotUniqueException{
		List<String> raceDateList = resultWebService.retrieveRaceDateList();
		List<String> raceNumList = resultWebService.getRaceNumList(raceDateList.get(0));
		resultWebService.getRaceResult(raceNumList.get(0));
	}
}
