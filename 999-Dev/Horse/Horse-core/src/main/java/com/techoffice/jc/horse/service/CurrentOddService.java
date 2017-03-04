package com.techoffice.jc.horse.service;

import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.jc.horse.crawler.CurrentOddCrawler;
import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@Service
public class CurrentOddService {
	
	@Autowired
	private CurrentOddCrawler currentOddCrawler;
	
	public void run() throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		List<String> raceNums = currentOddCrawler.getRaceNums();
		for (String raceNum: raceNums){
			List<CurrentOdd> currentOddList = currentOddCrawler.getCurrentOddByRaceNum(raceNum);
		}
	}
}
