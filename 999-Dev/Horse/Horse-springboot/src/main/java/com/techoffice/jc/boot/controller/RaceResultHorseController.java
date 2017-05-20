package com.techoffice.jc.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.jc.horse.service.RaceResultHorseService;

@Controller
@RequestMapping("/RaceResultHorse")
public class RaceResultHorseController {
	
	@Autowired
	private RaceResultHorseService raceResultHorseService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("RaceResultHorse");
		List<RaceResultHorse> raceResultHorselist = raceResultHorseService.list();
		mv.addObject("raceResultHorses", raceResultHorselist);
		return mv;
	}
	
	@RequestMapping("/{raceResultId}")
	public ModelAndView raceResult(@PathVariable("raceResultId") int raceResultId){
		ModelAndView mv = new ModelAndView("RaceResultHorse");
		List<RaceResultHorse> raceResultHorselist = raceResultHorseService.listByRaceResult(raceResultId);
		mv.addObject("raceResultHorses", raceResultHorselist);
		return mv;
	}
	
	@RequestMapping("/horseName/{horseName}")
	public ModelAndView horseName(@PathVariable("horseName") String horseName){
		ModelAndView mv = new ModelAndView("RaceResultHorseHistory");
		List<RaceResultHorse> raceResultHorselist = raceResultHorseService.listByHorseName(horseName);
		mv.addObject("raceResultHorses", raceResultHorselist);
		return mv;
	}}
