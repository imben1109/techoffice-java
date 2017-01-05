package com.techoffice.jc.horse.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.jc.horse.model.RaceDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class RaceDateDaoTest {
	
	@Autowired
	private RaceDateDao raceDateDao;
	
	@Test
	public void listPendingProcessRaceDate(){
		List<RaceDate> raceDateList = raceDateDao.getPendingRaceDateList();
		for (RaceDate raceDate: raceDateList){
			System.out.println(raceDate.getRaceDate() + " "  + raceDate.getRaceCount());
		}
	}
	
}
