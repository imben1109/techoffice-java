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
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.jc.horse.crawler.RaceResultCrawler;
import com.techoffice.jc.horse.dao.RaceResultDao;
import com.techoffice.jc.horse.dao.RaceResultHorseDao;
import com.techoffice.jc.horse.dao.RaceResultQueueDao;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultQueue;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@Service
public class ResultService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RaceResultCrawler resultWebService;
	
	@Autowired
	private RaceResultQueueDao raceResultQueueDao ;
	
	@Autowired
	private RaceResultDao raceResultDao;
	
	@Autowired
	private RaceResultHorseDao raceResultHorseDao;
	
	@Autowired
	private ResultQueueService resultQueueService;
	
	public void executeResultQueueList() {
		int successCount = 0;
		int failCount = 0;
		List<RaceResultQueue> raceResultQueueList = raceResultQueueDao.listActiveQueue();
		log.info("Number of Active Queue: " + raceResultQueueList.size());
		for (RaceResultQueue raceResultQueue: raceResultQueueList){
			try {
				resultQueueService.executeResultQueue(raceResultQueue);
				successCount++;
			} catch (Exception e) {
				resultQueueService.updateFailResultQueue(raceResultQueue);
				log.error("Exception when executing " + raceResultQueue.getLocation(), e);
				failCount++;
			}
		}
		log.info("Success Count: " + successCount);
		log.info("Fail Count: " + failCount);
	}
}
