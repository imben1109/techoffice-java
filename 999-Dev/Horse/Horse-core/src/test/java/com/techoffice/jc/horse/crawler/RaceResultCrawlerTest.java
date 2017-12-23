package com.techoffice.jc.horse.crawler;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.jc.horse.model.RaceDate;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.jc.horse.model.RaceResultQueue;
import com.techoffice.util.BeanUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class RaceResultCrawlerTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RaceResultCrawler raceResultCrawler;
	
//	@Test
	public void retrieveXml() {
		String xml = raceResultCrawler.retrieveXml();
		log.info(xml);
	}
	
//	@Test
	public void retrieveRaceDateList() {
		List<RaceDate> raceDateList = raceResultCrawler.getRaceDateList();
		for(RaceDate raceDate: raceDateList){
			log.info(raceDate.getUrl());
		}
	}
	
//	@Test
	public void getRaceResultQueueList() {
		List<RaceDate> raceDateList = raceResultCrawler.getRaceDateList();
		if (raceDateList.size() > 0){
			RaceDate raceDate = raceDateList.get(0);
			List<RaceResultQueue> raceResultQueueList = raceResultCrawler.getRaceResultQueueList(raceDate.getUrl());
			for (RaceResultQueue raceResultQueue: raceResultQueueList){
				log.info(BeanUtil.toString(raceResultQueue));
			}
		}
	} 
	
	@Test
	public void getRaceResult(){
		List<RaceDate> raceDateList = raceResultCrawler.getRaceDateList();
		if (raceDateList.size() > 0){
			RaceDate raceDate = raceDateList.get(0);
			List<RaceResultQueue> raceResultQueueList = raceResultCrawler.getRaceResultQueueList(raceDate.getUrl());
			if (raceResultQueueList.size() > 0){
				RaceResultQueue raceResultQueue = raceResultQueueList.get(0);
				RaceResult raceResult = raceResultCrawler.getRaceResult(raceResultQueue.getLocation());
				log.info(BeanUtil.toString(raceResult));
				List<RaceResultHorse> raceResultHorseList = raceResult.getRaceResultHorseList();
				for (RaceResultHorse raceResultHorse: raceResultHorseList){
					log.info(BeanUtil.toString(raceResultHorse));
				}
			}
		}
	}
	
}
