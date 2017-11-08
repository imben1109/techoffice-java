package com.techoffice.jc.boot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.service.RaceResultService;

@RequestMapping("RaceResult")
@Controller
public class RaceResultController {

	@Autowired
	private RaceResultService raceResultService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("RaceResult");
		List<RaceResult> raceResults = raceResultService.list();
		view.addObject("raceResults", raceResults);
		return view;
	}

	@RequestMapping("/{raceDate}")
	public ModelAndView raceDate(@PathVariable("raceDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date raceDate){
		ModelAndView view = new ModelAndView("RaceResult");
		List<RaceResult> raceResults = raceResultService.listByRaceDate(raceDate);
		view.addObject("raceResults", raceResults);
		return view;
	}
	
}
