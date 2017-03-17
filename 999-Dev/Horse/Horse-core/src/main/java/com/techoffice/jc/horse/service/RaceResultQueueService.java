package com.techoffice.jc.horse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.jc.horse.dao.RaceResultQueueDao;
import com.techoffice.jc.horse.model.RaceResultQueue;

@Service
public class RaceResultQueueService {

	@Autowired
	private RaceResultQueueDao raceResultQueueDao;
	
	public List<RaceResultQueue> list(){
		return raceResultQueueDao.list();
	}
}
