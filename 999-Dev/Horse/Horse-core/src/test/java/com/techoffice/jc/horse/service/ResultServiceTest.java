package com.techoffice.jc.horse.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

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
import com.techoffice.util.exception.XpathException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class ResultServiceTest {
	
	@Autowired
	private RaceResultService raceResultService;
	
	@Autowired
	private RaceResultQueueBatchService resultService;
	
//	@Test
	public void executeResultQueue() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XpathException, ParseException{
		for (int i=0; i<50; i++){
			resultService.executeResultQueues();	
		}
	}
	
	@Test
	public void correctRaceDate() throws ParseException{
		raceResultService.correctRaceDate();
	}
}
