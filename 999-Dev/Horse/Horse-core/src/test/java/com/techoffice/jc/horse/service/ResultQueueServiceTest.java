package com.techoffice.jc.horse.service;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class ResultQueueServiceTest {
	
	@Autowired
	private RaceDateService resultQueueDateService;
	
	@Autowired
	private RaceResultQueueService resultQueueService;
	
	@Test
	public void correctQueueRaceDate() throws ParseException{
//		resultQueueService.correctQueueRaceDate();
	}
	
}
