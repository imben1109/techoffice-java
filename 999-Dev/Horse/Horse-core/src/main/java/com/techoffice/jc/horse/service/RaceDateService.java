package com.techoffice.jc.horse.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.techoffice.jc.horse.model.RaceDate;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

@Service
public class RaceDateService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RaceDateDao raceDateDao;
	
	@Autowired
	private RaceResultCrawler raceResultCrawler;
	
	public List<RaceDate> list(){
		return raceDateDao.list();
	}
	
	/**
	 * Update Database Race Date from HKJC web site.
	 * http://racing.hkjc.com/racing/Info/meeting/Results/English/
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
	public Map<String, Integer> updateRaceDateList() throws XPathExpressionException, XmlUtilDocumentConversionException  {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 0; 
		List<RaceDate> hkjcRaceDateList = raceResultCrawler.retrieveRaceDateList();
		for (RaceDate newRaceDate: hkjcRaceDateList){
			RaceDate raceDate = raceDateDao.getByRaceDate(newRaceDate.getRaceDate());
			if (raceDate == null){
				raceDateDao.update(newRaceDate);
				count++;
			}
		}
		int total = raceDateDao.list().size();
		log.info("Retrieved Race Date Count: " + hkjcRaceDateList.size());
		log.info("Inserted Race Date Count: " + count);
		log.info("Total Race Date in Database: " + total );
		map.put("retrieved", hkjcRaceDateList.size());
		map.put("Inserted", count);
		map.put("total", total);
		return map;
	}
	
}
