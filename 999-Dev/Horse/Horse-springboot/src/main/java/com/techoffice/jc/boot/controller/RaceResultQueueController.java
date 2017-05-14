package com.techoffice.jc.boot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.jc.horse.model.RaceResultQueue;
import com.techoffice.jc.horse.service.RaceResultQueueService;

@RequestMapping("RaceResultQueue")
@Controller
public class RaceResultQueueController {

	@Autowired
	private RaceResultQueueService RaceResultQueueService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("RaceResultQueue");
		List<RaceResultQueue> raceResultQueues = RaceResultQueueService.list();
		view.addObject("raceResultQueues", raceResultQueues);
		return view;
	}
	
	
	public ModelAndView raceDate(@DateTimeFormat(pattern="yyyyMMdd") Date raceDate){
		ModelAndView view = new ModelAndView("RaceResultQueue");
		return view;

	}
	
}
