package com.techoffice.jc.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.jc.horse.service.RaceResultHorseService;

@RequestMapping("/RaceResultHorse")
public class RaceResultHorseController {
	
	@Autowired
	private RaceResultHorseService raceResultHorseService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("RaceResultHorse");
		List<RaceResultHorse> raceResultHorselist = raceResultHorseService.list();
		mv.addObject("raceResultHorseList", raceResultHorselist);
		return mv;
	}
}
