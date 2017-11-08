package com.techoffice.jc.boot.temp;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.jc.horse.crawler.RaceResultCrawler;
import com.techoffice.jc.horse.dao.RaceResultDao;
import com.techoffice.jc.horse.dao.RaceResultHorseDao;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.util.exception.XpathException;

@Service
public class TempService {
	
	@Autowired
	private TempDao tempDao;
	
	@Autowired
	private RaceResultDao raceResultDao;
	
	@Autowired
	private RaceResultCrawler raceResultCrawler;
	
	@Autowired
	private RaceResultHorseDao raceResultHorseDao;
	
	public void run(){
		List<Integer> list = tempDao.get();
		for(Integer i: list){
			RaceResult raceResult = raceResultDao.get(i);
			List<RaceResultHorse> horses = raceResult.getRaceResultHorseList();
			String location = raceResult.getLocation();
			try {
				RaceResult crawlerRaceResult = raceResultCrawler.getRaceResult(location);
				List<RaceResultHorse> crawlerRaceResultHorses = crawlerRaceResult.getRaceResultHorseList();
				for (RaceResultHorse horse: horses){
					for (RaceResultHorse crawlerRaceResultHorse: crawlerRaceResultHorses){
						if (horse.getHorseName().equals(crawlerRaceResultHorse.getHorseName())){
							horse.setJockey(crawlerRaceResultHorse.getJockey());
							horse.setTrainer(crawlerRaceResultHorse.getTrainer());
							raceResultHorseDao.update(horse);
						}
					}
				}
			} catch (XpathException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
}
