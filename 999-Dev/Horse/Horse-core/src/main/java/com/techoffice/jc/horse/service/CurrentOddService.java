package com.techoffice.jc.horse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.jc.horse.crawler.CurrentOddCrawler;
import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.util.exception.DocumentConversionException;
import com.techoffice.util.exception.XpathException;

@Service
public class CurrentOddService {
	
	@Autowired
	private CurrentOddCrawler currentOddCrawler;
	
	public Map<String, List<CurrentOdd>> getCurrentOddMap() throws XPathExpressionException, DocumentConversionException, XpathException{
		Map<String, List<CurrentOdd>> map = new HashMap<String, List<CurrentOdd>>();
		List<String> raceNums = currentOddCrawler.getRaceNums();
		for (String raceNum: raceNums){
			List<CurrentOdd> currentOddList = currentOddCrawler.getCurrentOddByRaceNum(raceNum);
			map.put(raceNum, currentOddList);
		}
		return map;
	}
}
