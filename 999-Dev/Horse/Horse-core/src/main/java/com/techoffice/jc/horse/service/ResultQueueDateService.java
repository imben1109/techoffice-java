package com.techoffice.jc.horse.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
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
import com.techoffice.jc.horse.dao.RaceResultQueueDao;
import com.techoffice.jc.horse.model.RaceDate;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

@Service
public class ResultQueueDateService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RaceResultQueueService resultQueueService;
	
	@Autowired
	private RaceDateDao raceDateDao;
	
	@Autowired
	private RaceResultQueueDao raceResultQueueDao ;
	
	
	@Transactional
	public Map<String, Object> getPendingQueueDateList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<RaceDate> raceDateList = raceDateDao.getPendingRaceDateList();
		map.put("list", raceDateList);
		map.put("count", raceDateList.size());
		return map;
	}
	
	
}
