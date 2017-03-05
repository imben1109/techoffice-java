package com.techoffice.jc.horse.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.jc.horse.crawler.RaceResultCrawler;
import com.techoffice.jc.horse.dao.RaceDateDao;
import com.techoffice.jc.horse.dao.RaceResultDao;
import com.techoffice.jc.horse.dao.RaceResultQueueDao;
import com.techoffice.jc.horse.model.RaceDate;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultQueue;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@Service
public class ResultQueueService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RaceResultCrawler raceResultCrawler;
	
	@Autowired
	private RaceResultQueueDao raceResultQueueDao ;
	
	@Autowired
	private RaceResultDao raceResultDao;
	
	@Transactional
	public void executeResultQueue(RaceResultQueue queue) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilXpathNotUniqueException, ParseException, XmlUtilDocumentConversionException{
		log.info("It is executing " + queue.getLocation());
		RaceResult raceResult = raceResultCrawler.getRaceResult(queue.getLocation());
		raceResultDao.add(raceResult);
		queue.setRunInd("Y");
		raceResultQueueDao.update(queue);
		log.info("raceResult with id:" + raceResult.getId() + " is created.");
	}
	
	@Transactional
	public void updateFailResultQueue(RaceResultQueue queue){
		queue.setRunInd("E");
		raceResultQueueDao.update(queue);
	}
	
	@Transactional
	public void updateResultQueue(RaceResultQueue queue){
		RaceResultQueue raceResultQueue = raceResultQueueDao.getRaceResultQueueByLocation(queue.getLocation());
		if (raceResultQueue == null){
			raceResultQueueDao.addRaceResultQueue(queue);
		}
	}
	
	/**
	 * For each race data, there would be a number of race. 
	 * The number of race would corresponds to a queue for updating the race result.
	 * 
	 * The methods is to update/insert race result queue for a specified race date.
	 * 
	 * @param raceDate
	 * @return
	 * @throws FailingHttpStatusCodeException
	 * @throws MalformedURLException
	 * @throws XPathExpressionException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws InterruptedException
	 * @throws TransformerException
	 * @throws ParseException
	 * @throws XmlUtilDocumentConversionException 
	 */
	@Transactional
	public int updateResultQueueByRaceDate(String raceDate) throws XPathExpressionException, XmlUtilDocumentConversionException, ParseException{
		int raceResultCount = 0;
		List<RaceResultQueue> raceResultQueueList = raceResultCrawler.getRaceResultQueueList(raceDate);
		for(RaceResultQueue queue: raceResultQueueList){
			updateResultQueue(queue);
			raceResultCount++;
		}
		return raceResultCount;
	}
	
	
	
	
}
