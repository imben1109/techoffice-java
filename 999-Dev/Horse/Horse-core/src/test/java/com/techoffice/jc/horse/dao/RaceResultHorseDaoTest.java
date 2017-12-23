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
import com.techoffice.jc.horse.model.helper.RaceResultHorseHelper;
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
		int count = 0;
		int win = 0;
		int loss = 0;
		int place = 0;
		List<RaceResultHorse> horseWithLargeDistanceList = raceResultHorseDao.listByPlaceOneTwoThree();
		for (RaceResultHorse horseWithLargeDistance: horseWithLargeDistanceList){
			List<RaceResultHorse> raceResultHorseList = raceResultHorseDao.listByHorseName(horseWithLargeDistance.getHorseName());
			RaceResultHorse nextRaceHorse = RaceResultHorseHelper.getNextRaceResultHorse(horseWithLargeDistance, raceResultHorseList);
			if (nextRaceHorse != null){
				count++;
				if (nextRaceHorse.getPlace().equals("1")){
					win++;
				}
				if (nextRaceHorse.getPlace().equals("1") ||
						nextRaceHorse.getPlace().equals("2") ||
						nextRaceHorse.getPlace().equals("3")){
					place ++;
				}else {
					loss++;
				}
			}else {
//				log.info("No Next Race Horse for " + BeanUtil.toString(horseWithLargeDistance));
			}
		}
		log.info("Total: " + count + " Win:" + win + "Place: " + place + " Loss: " + loss);
	}
}
