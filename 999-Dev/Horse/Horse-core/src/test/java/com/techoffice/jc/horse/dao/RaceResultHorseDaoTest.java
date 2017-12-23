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

import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.util.BeanUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class RaceResultHorseDaoTest {

	@Autowired
	private RaceResultHorseDao raceResultHorseDao;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	@Transactional
	public void list(){
		List<RaceResultHorse> raceResultHorseList = raceResultHorseDao.list();
		for (RaceResultHorse raceResultHorse: raceResultHorseList){
			log.info(BeanUtil.toString(raceResultHorse.getRaceResult()));
		}
	}
	
	@Test
	@Transactional
	public void listDistinctHosre(){
		List<String> horseNameList = raceResultHorseDao.getHorseNameList();
		for (String horseName: horseNameList){
			log.info(horseName);
		}
	}
	
	@Test
	@Transactional
	public void test(){
		List<RaceResultHorse> horseWithLargeDistanceList = raceResultHorseDao.listWithLargeDistance();
		for (RaceResultHorse horseWithLargeDistance: horseWithLargeDistanceList){
			List<RaceResultHorse> raceResultHorseList = raceResultHorseDao.listByHorseName(horseWithLargeDistance.getHorseName());
			
		}
	}
}
