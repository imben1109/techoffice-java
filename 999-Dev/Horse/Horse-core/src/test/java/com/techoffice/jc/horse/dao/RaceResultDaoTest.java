package com.techoffice.jc.horse.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class RaceResultDaoTest {
	
	@Autowired
	private RaceResultDao raceResultDao;
	
	@Test
	public void test(){
		RaceResult raceResult = new RaceResult();
		List<RaceResultHorse> raceResultHorseList = new ArrayList<RaceResultHorse>();
		RaceResultHorse raceResultHorse1 = new RaceResultHorse();
		RaceResultHorse raceResultHorse2 = new RaceResultHorse();
		raceResultHorseList.add(raceResultHorse1);
		raceResultHorseList.add(raceResultHorse2);
		raceResult.setRaceResultHorseList(raceResultHorseList);

		raceResultDao.update(raceResult);
		System.out.println("Race Result (ID: " + raceResult.getId() + ") is created");
		System.out.println("Race Result Horse (ID: " + raceResultHorse1.getId() + ") is created");
		System.out.println("Race Result Horse (ID: " + raceResultHorse2.getId() + ") is created");
		
		raceResultDao.delete(raceResult);

	}
}
