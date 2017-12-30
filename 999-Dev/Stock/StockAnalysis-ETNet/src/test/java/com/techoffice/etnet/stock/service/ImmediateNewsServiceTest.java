package com.techoffice.etnet.stock.service;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.etnet.news.service.ImmediateNewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class ImmediateNewsServiceTest {
	
	@Autowired
	private ImmediateNewsService immediateNewsService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getWordOccurrenceMap(){
		Map<String, Integer> map = immediateNewsService.getNewsKeyWordOccurrenceMap();
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			log.info(entry.getKey() + " " + entry.getValue());
		}
	}
	
	@Test
	public void getAllWordOccurrenceMap(){
		Map<String, Map<String, Integer>> map = immediateNewsService.getAllNewsKeyWordOccurrenceMap();
		for(Entry<String, Map<String, Integer>> yearMap: map.entrySet()){
			log.info(yearMap.getKey());
			log.info("===");
			for(Map.Entry<String, Integer> entry: yearMap.getValue().entrySet()){
				log.info(entry.getKey() + " " + entry.getValue());
			}
		}
	}
}
