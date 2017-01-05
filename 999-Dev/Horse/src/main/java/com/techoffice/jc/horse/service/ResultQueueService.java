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
	
	@Autowired
	private RaceDateDao raceDateDao;
	
	@Transactional
	public void executeResultQueue(RaceResultQueue raceResultQueue) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilXpathNotUniqueException, ParseException{
		log.info("It is executing " + raceResultQueue.getLocation() );
		RaceResult raceResult = raceResultCrawler.getRaceResult(raceResultQueue.getLocation());
		raceResultDao.add(raceResult);
		raceResultQueue.setRunInd("Y");
		raceResultQueueDao.update(raceResultQueue);
		log.info("raceResult with id:" + raceResult.getId() + " is created.");
	}
	
	@Transactional
	public void updateFailResultQueue(RaceResultQueue raceResultQueue){
		raceResultQueue.setRunInd("E");
		raceResultQueueDao.update(raceResultQueue);
	}
	
	@Transactional
	public void updateResultQueue(RaceResultQueue queue){
		RaceResultQueue raceResultQueue = raceResultQueueDao.getRaceResultQueueByLocation(queue.getLocation());
		if (raceResultQueue == null){
			raceResultQueueDao.addRaceResultQueue(queue);
		}else{
			// Special Handling here because the previous processing do not include venue, race type and race date
			raceResultQueue.setRaceDate(queue.getRaceDate());
			raceResultQueue.setRaceType(queue.getRaceType());
			raceResultQueue.setVenue(queue.getVenue());
			raceResultQueueDao.update(raceResultQueue);
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
	 */
	@Transactional
	public int updateResultQueueByRaceDate(String raceDate) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, ParseException{
		int raceResultCount = 0;
		List<RaceResultQueue> raceResultQueueList = raceResultCrawler.getRaceResultQueueList(raceDate);
		for(RaceResultQueue queue: raceResultQueueList){
			updateResultQueue(queue);
			raceResultCount++;
		}
		return raceResultCount;
	}
	
	/**
	 * Update Database Race Date from HKJC web site.
	 * 
	 * @throws FailingHttpStatusCodeException
	 * @throws MalformedURLException
	 * @throws XPathExpressionException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws InterruptedException
	 * @throws TransformerException
	 */
	@Transactional
	public void updateRaceDateList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		int count = 0; 
		List<RaceDate> newRaceDateList = raceResultCrawler.retrieveRaceDateList();
		for (RaceDate newRaceDate: newRaceDateList){
			RaceDate raceDate = raceDateDao.getByRaceDate(newRaceDate.getRaceDate());
			if (raceDate == null){
				raceDateDao.add(newRaceDate);
				count++;
			}
		}
		log.info("Retrieved Race Date Count: " + newRaceDateList.size());
		log.info("Inserted Race Date Count: " + count);
	}
	
	/**
	 * For each race date, it would be more than one races. 
	 * The races would be corresponded to a race queue for updating race result.
	 *
	 * This method would create race queue for race date.
	 * 
	 * @throws FailingHttpStatusCodeException
	 * @throws MalformedURLException
	 * @throws XPathExpressionException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws InterruptedException
	 * @throws TransformerException
	 * @throws ParseException
	 */
	@Transactional
	public void updateRaceResultQueueList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, ParseException {
		int raceResultTotalCount = 0;
		int pendingCount = 0;
		int processedCount = 0;
		List<RaceDate> raceDateList = raceDateDao.getPendingRaceDateList();
		for(RaceDate raceDate: raceDateList){
			int raceResultCount = updateResultQueueByRaceDate(raceDate.getRaceDate());
			raceDate.setRaceCount(raceResultCount);
			raceDateDao.update(raceDate);
			raceResultTotalCount += raceResultCount;
			if(raceResultCount > 1){
				processedCount++;
			}else{
				pendingCount++;
			}
		}
		int totalRaceResultQueueCount = raceResultQueueDao.list().size();
		log.info("Total Race Result Queue: " + totalRaceResultQueueCount);
		log.info(raceResultTotalCount + " Reace Results is inserted or updated into the Queue.");
		log.info("Pending Race Date Count: " + pendingCount);
		log.info("Processed Race Date Count: " + processedCount);
	}
	
	
}
