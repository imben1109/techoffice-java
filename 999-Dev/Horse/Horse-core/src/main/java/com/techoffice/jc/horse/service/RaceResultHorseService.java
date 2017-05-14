package com.techoffice.jc.horse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.jc.horse.dao.RaceResultHorseDao;
import com.techoffice.jc.horse.model.RaceResultHorse;

@Service
public class RaceResultHorseService {
	
	@Autowired
	private RaceResultHorseDao raceResultHorseDao;
	
	public List<RaceResultHorse> list(){
		return raceResultHorseDao.list();
	}
}
