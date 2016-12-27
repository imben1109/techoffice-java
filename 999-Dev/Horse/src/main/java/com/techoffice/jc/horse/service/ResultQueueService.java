package com.techoffice.jc.horse.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

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
import com.techoffice.jc.horse.dao.RaceResultDao;
import com.techoffice.jc.horse.dao.RaceResultQueueDao;
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
}
