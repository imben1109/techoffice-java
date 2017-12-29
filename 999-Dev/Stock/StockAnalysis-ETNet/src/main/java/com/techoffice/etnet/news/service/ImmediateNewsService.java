package com.techoffice.etnet.news.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.util.SpecialStringUtil;
import com.techoffice.util.StringUtil;

/**
 * HKET Immediate News Service 
 * 
 * @author TechOffice
 *
 */
@Component
public class ImmediateNewsService {

	@Autowired
	private ImmediateNewsCrawler immediateNewsCrawler;
	
	public Map<String, Integer> getNewsKeyWordOccurrenceMap(){
		List<String> newsList = immediateNewsCrawler.getNewsList();
		newsList = SpecialStringUtil.getChineseStringList(newsList);
		Map<String, Integer> occurrenceMap = StringUtil.getOccurrenceMap(newsList, 2);
		return occurrenceMap;
	}
	
}
