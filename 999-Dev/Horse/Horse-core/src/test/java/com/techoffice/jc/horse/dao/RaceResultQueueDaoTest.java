package com.techoffice.jc.horse.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.jc.horse.model.RaceResultQueue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class RaceResultQueueDaoTest {
	
	@Autowired
	private RaceResultQueueDao raceResultQueueDao;
	
//	@Test
	public void listActiveQueue(){
		List<RaceResultQueue> list = raceResultQueueDao.listActiveQueue();
		for (RaceResultQueue queue: list){
			System.out.println(queue.getLocation() + " " + queue.getRunInd());
		}
	}
	
	@Test
	public void getRaceResultQueueByLocation(){
		RaceResultQueue queue = raceResultQueueDao.getRaceResultQueueByLocation("/racing/Info/Meeting/Results/English/Local/20161211/ST/4");
		System.out.println(queue.getId());
	}
}
