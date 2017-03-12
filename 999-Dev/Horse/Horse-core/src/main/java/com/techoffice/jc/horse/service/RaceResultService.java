package com.techoffice.jc.horse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.jc.horse.dao.RaceResultDao;

@Service
public class RaceResultService {

	@Autowired
	private RaceResultDao raceResultDao;
	
	public List<String> listVenue(){
		return raceResultDao.listVenue();
	}
}
