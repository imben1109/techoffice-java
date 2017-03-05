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
import com.techoffice.jc.horse.dao.RaceResultQueueDao;
import com.techoffice.jc.horse.model.RaceDate;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

@Service
public class ResultQueueDateService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResultQueueService resultQueueService;
	
	@Autowired
	private RaceResultCrawler raceResultCrawler;
	
	@Autowired
	private RaceDateDao raceDateDao;
	
	@Autowired
	private RaceResultQueueDao raceResultQueueDao ;
	
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
	 * @throws XmlUtilDocumentConversionException 
	 */
	@Transactional
	public void updateRaceDateList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilDocumentConversionException{
		int count = 0; 
		List<RaceDate> newRaceDateList = raceResultCrawler.retrieveRaceDateList();
		for (RaceDate newRaceDate: newRaceDateList){
			RaceDate raceDate = raceDateDao.getByRaceDate(newRaceDate.getRaceDate());
			if (raceDate == null){
				raceDateDao.update(newRaceDate);
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
	 * @throws XmlUtilDocumentConversionException 
	 */
	@Transactional
	public void updateRaceResultQueueList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, ParseException, XmlUtilDocumentConversionException {
		int raceResultTotalCount = 0;
		int pendingCount = 0;
		int processedCount = 0;
		List<RaceDate> raceDateList = raceDateDao.getPendingRaceDateList();
		for(RaceDate raceDate: raceDateList){
			int raceResultCount = resultQueueService.updateResultQueueByRaceDate(raceDate.getRaceDate());
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
