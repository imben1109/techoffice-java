package com.techoffice.jc.horse.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.model.RaceResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class RaceResultDaoTest {

	@Autowired
	private RaceResultDao raceResultDao;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	@Transactional
	public void list(){
		List<RaceResult> raceResultList = raceResultDao.list();
		for (RaceResult raceResult: raceResultList){
			log.info("" + raceResult.getRaceResultHorseList().size());
		}
	}
}
