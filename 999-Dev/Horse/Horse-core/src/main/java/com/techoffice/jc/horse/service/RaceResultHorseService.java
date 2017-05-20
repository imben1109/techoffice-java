package com.techoffice.jc.horse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.jc.horse.dao.RaceResultHorseDao;
import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;

@Service
public class RaceResultHorseService {
	
	@Autowired
	private RaceResultHorseDao raceResultHorseDao;
	
	public List<RaceResultHorse> list(){
		return raceResultHorseDao.list();
	}
	
	public List<RaceResultHorse> list(RaceResult raceResult){
		return raceResultHorseDao.listByRaceResult(raceResult);
	}
	
	public List<RaceResultHorse> listByRaceResult(int raceResultId){
		return raceResultHorseDao.listByRaceResult(raceResultId);
	}
	
	public List<RaceResultHorse> listByHorseName(String horseName){
		return raceResultHorseDao.listByHorseName(horseName);
	}
}
