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
import com.techoffice.jc.horse.dao.RaceDateDao;
import com.techoffice.jc.horse.dao.RaceResultDao;
import com.techoffice.jc.horse.dao.RaceResultQueueDao;
import com.techoffice.jc.horse.model.RaceDate;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultQueue;
import com.techoffice.jc.horse.service.web.ResultWebService;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@Service
public class ResultQueueService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResultWebService resultWebService;
	
	@Autowired
	private RaceResultQueueDao raceResultQueueDao ;
	
	@Autowired
	private RaceResultDao raceResultDao;
	
	@Autowired
	private RaceDateDao raceDateDao;
	
	@Transactional
	public void executeResultQueue(RaceResultQueue raceResultQueue) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilXpathNotUniqueException, ParseException{
		log.info("It is executing " + raceResultQueue.getLocation() );
		RaceResult raceResult = resultWebService.getRaceResult(raceResultQueue.getLocation());
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
	
	@Transactional
	public int updateResultQueueByRaceDate(String raceDate) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, ParseException{
		int raceResultCount = 0;
		List<RaceResultQueue> raceResultQueueList = resultWebService.getRaceResultQueueList(raceDate);
		for(RaceResultQueue queue: raceResultQueueList){
			updateResultQueue(queue);
			raceResultCount++;
		}
		return raceResultCount;
	}
	
	@Transactional
	public void updateRaceDate() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		List<RaceDate> newRaceDateList = resultWebService.retrieveRaceDateList();
		for (RaceDate newRaceDate: newRaceDateList){
			RaceDate raceDate = raceDateDao.getByRaceDate(newRaceDate.getRaceDate());
			if (raceDate == null){
				raceDateDao.add(raceDate);
			}
		}
	}
	
	@Transactional
	public void executePendingProcessRaceDate() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, ParseException {
		int raceResultTotalCount = 0;
		int pendingCount = 0;
		int processedCount = 0;
		List<RaceDate> raceDateList = raceDateDao.listPendingProcessRaceDate();
		for(RaceDate raceDate: raceDateList){
			int raceResultCount = updateResultQueueByRaceDate(raceDate.getRaceDate());
			raceDate.setRaceCount(raceResultCount);
			raceDateDao.add(raceDate);
			raceResultTotalCount += raceResultCount;
			if(raceResultCount > 1){
				processedCount++;
			}else{
				pendingCount++;
			}
		}
		log.info(raceResultTotalCount + " Reace Results is inserted or updated into the Queue.");
		log.info("Pending Race Date Count: " + pendingCount);
		log.info("Processed Race Date Count: " + processedCount);
	}
	
	
}
