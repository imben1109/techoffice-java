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

import com.techoffice.etnet.news.service.ImmediateNewsOccurrenceMapService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class ImmediateNewsOccurrenceMapServiceTest {
	
	@Autowired
	private ImmediateNewsOccurrenceMapService immediateNewsOccurrenceMapService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getNewsKeyWordOccurrenceMap(){
		Map<String, Integer> map = immediateNewsOccurrenceMapService.getNewsKeyWordOccurrenceMap();
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			log.info(entry.getKey() + " " + entry.getValue());
		}
	}
	
	@Test
	public void getAllNewsKeyWordOccurrenceMap(){
		Map<String, Map<String, Integer>> map = immediateNewsOccurrenceMapService.getAllNewsKeyWordOccurrenceMap();
		for(Entry<String, Map<String, Integer>> yearMap: map.entrySet()){
			log.info(yearMap.getKey());
			log.info("===");
			for(Map.Entry<String, Integer> entry: yearMap.getValue().entrySet()){
				log.info(entry.getKey() + " " + entry.getValue());
			}
		}
	}
}
