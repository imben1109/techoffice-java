package com.techoffice.jc.horse.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.jc.horse.dao.RaceResultDao;
import com.techoffice.jc.horse.model.RaceResult;

@Service
public class RaceResultService {

	@Autowired
	private RaceResultDao raceResultDao;
	
	public List<RaceResult> list(){
		return raceResultDao.list();
	}
	
	public List<String> listVenue(){
		return raceResultDao.listVenue();
	}

	@Transactional
	public void correctRaceDate() throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		List<RaceResult> raceResults = raceResultDao.list();
		for(RaceResult reaceResult: raceResults){
			String raceDateStr = reaceResult.getLocation().split("/")[7];
			Date parsedDate = format.parse(raceDateStr);
			if (parsedDate != reaceResult.getRaceDate()){
				reaceResult.setRaceDate(parsedDate);
				raceResultDao.update(reaceResult);
			}
		}
	}
}
