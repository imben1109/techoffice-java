package com.techoffice.etnet.news.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.etnet.news.model.AvailableNewsDate;
import com.techoffice.etnet.news.model.CrawledNews;
import com.techoffice.util.ListUtil;
import com.techoffice.util.SpecialStringUtil;
import com.techoffice.util.StringUtil;

/**
 * HKET Immediate News Service 
 * 
 * @author TechOffice
 *
 */
@Component
public class ImmediateNewsOccurrenceMapService {

	@Autowired
	private ImmediateNewsCrawler immediateNewsCrawler; 
	
	public Map<String, Integer> getNewsKeyWordOccurrenceMap(){
		return getNewsKeyWordOccurrenceMap(null);
	}
	
	public Map<String, Integer> getNewsKeyWordOccurrenceMap(String url){
		List<CrawledNews> crawledNewsList = null;
		if (url == null){
			crawledNewsList = immediateNewsCrawler.getNewsList();
		}else {
			crawledNewsList = immediateNewsCrawler.getNewsList(url);
		}
		List<String> newsList = ListUtil.getAttributeList(crawledNewsList, "contents");
		newsList = SpecialStringUtil.getChineseStringList(newsList);
		Map<String, Integer> occurrenceMap = StringUtil.getOccurrenceMap(newsList, 2);
		return occurrenceMap;
	}
	
	public Map<String, Map<String, Integer>> getAllNewsKeyWordOccurrenceMap(){
		Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
		List<AvailableNewsDate> availNewsDateList = immediateNewsCrawler.getAvailableDateList();
		for (AvailableNewsDate availableNewsDate: availNewsDateList){
			Map<String, Integer> newsKeyWordOccurrenceMap = getNewsKeyWordOccurrenceMap(availableNewsDate.getUrl());
			map.put(availableNewsDate.getDesc(), newsKeyWordOccurrenceMap);
		}
		return map; 
	}
	
}
