package com.techoffice.etnet.news.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.etnet.news.dao.AvailableNewsDateDao;
import com.techoffice.etnet.news.dao.NewsDao;
import com.techoffice.etnet.news.entity.AvailableNewsDate;
import com.techoffice.etnet.news.entity.News;
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
	private NewsDao newsDao;
	
	@Autowired
	private AvailableNewsDateDao availableNewsDateDao;
	
	public Map<String, Integer> getNewsKeyWordOccurrenceMap(){
		return getNewsKeyWordOccurrenceMap(null);
	}
	
	public Map<String, Integer> getNewsKeyWordOccurrenceMap(Date postDate){
		List<News> newsList = null;
		if (postDate == null){
			newsList = newsDao.list();
		}else {
			newsList = newsDao.listByPostDate(postDate);
		}
		List<String> newsContentsList = ListUtil.getAttributeList(newsList, "contents");
		newsContentsList = SpecialStringUtil.getChineseStringList(newsContentsList);
		Map<String, Integer> occurrenceMap = StringUtil.getOccurrenceMap(newsContentsList, 2);
		return occurrenceMap;
	}
	
	public Map<String, Map<String, Integer>> getAllNewsKeyWordOccurrenceMap(){
		Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
		List<AvailableNewsDate> availNewsDateList = availableNewsDateDao.listRun();
		for (AvailableNewsDate availableNewsDate: availNewsDateList){
			Map<String, Integer> newsKeyWordOccurrenceMap = getNewsKeyWordOccurrenceMap(availableNewsDate.getPostDate());
			map.put(availableNewsDate.getDateStr(), newsKeyWordOccurrenceMap);
		}
		return map; 
	}
	
}
