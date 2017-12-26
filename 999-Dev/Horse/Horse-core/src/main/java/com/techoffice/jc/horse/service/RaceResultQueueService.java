package com.techoffice.jc.horse.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.techoffice.jc.horse.crawler.RaceResultCrawler;
import com.techoffice.jc.horse.dao.RaceResultDao;
import com.techoffice.jc.horse.dao.RaceResultHorseDao;
import com.techoffice.jc.horse.dao.RaceResultQueueDao;
import com.techoffice.jc.horse.helper.RaceResultHelper;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultQueue;
import com.techoffice.util.exception.DocumentConversionException;
import com.techoffice.util.exception.XpathException;

@Service
public class RaceResultQueueService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RaceResultCrawler raceResultCrawler;
	
	@Autowired
	private RaceResultQueueDao raceResultQueueDao ;
	
	@Autowired
	private RaceResultDao raceResultDao;
	
	@Autowired
	private RaceResultHorseDao raceResultHorseDao ;
	
	public List<RaceResultQueue> list(){
		return raceResultQueueDao.list();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void executeResultQueue(RaceResultQueue queue) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XpathException, ParseException, DocumentConversionException {
		log.info("It is executing " + queue.getLocation());
		RaceResult raceResult = raceResultCrawler.getRaceResult(queue.getLocation());
		raceResultDao.update(raceResult);
		raceResultHorseDao.addList(raceResult.getRaceResultHorseList());
		updateResultQueueStatus(queue, "Y");
		log.info("raceResult with id:" + raceResult.getId() + " is created.");
	}
	
	@Transactional
	public void updateResultQueueStatus(RaceResultQueue queue, String status){
		queue = raceResultQueueDao.get(queue.getId());
		queue.setRunInd(status);
		raceResultQueueDao.update(queue);
	}
	
	@Transactional
	public void updateResultQueue(RaceResultQueue queue){
		RaceResultQueue raceResultQueue = raceResultQueueDao.getRaceResultQueueByLocation(queue.getLocation());
		if (raceResultQueue == null){
			raceResultQueueDao.addRaceResultQueue(queue);
		}
	}
	
	public List<RaceResultQueue> listActiveQueue(){
		return raceResultQueueDao.listActiveQueue();
	}
	
	public List<RaceResultQueue> listByRaceDate(Date raceDate){
		return raceResultQueueDao.listByRaceDate(raceDate);
	}
	
	/**
	 * For each race data, there would be a number of race. 
	 * The number of race would corresponds to a queue for updating the race result.
	 * 
	 * The methods is to update/insert race result queue for a specified race date.
	 * 
	 * @param url
	 * @return
	 * @throws XpathException 
	 * @throws ParseException
	 */
	@Transactional
	public int updateResultQueuesByUrl(String url)  {
		int raceResultCount = 0;
		List<RaceResultQueue> raceResultQueueList = raceResultCrawler.getRaceResultQueueList(url);
		log.info("Number of Race Result Queues of " + url + ": " + raceResultQueueList.size());
		for(RaceResultQueue queue: raceResultQueueList){
			updateResultQueue(queue);
			raceResultCount++;
		}
		return raceResultCount;
	}
	
	@Transactional
	public void correctQueueRaceDate() throws ParseException{
		List<RaceResultQueue> raceResultQueueList = raceResultQueueDao.list();
		for (RaceResultQueue queue: raceResultQueueList ){
			String location = queue.getLocation();
			String[] locationArr = location.split("/");
			String dateStr = locationArr[7];
			Date parsedDate = RaceResultHelper.getRaceDate(dateStr);
			Date raceDate = queue.getRaceDate();
			if (parsedDate != raceDate){
				queue.setRaceDate(parsedDate);
				raceResultQueueDao.update(queue);
			}
		}
	}
	
	
	
}
