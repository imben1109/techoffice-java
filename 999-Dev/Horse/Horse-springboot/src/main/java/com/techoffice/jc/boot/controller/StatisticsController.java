package com.techoffice.jc.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.jc.horse.service.RaceResultService;

@Controller
@RequestMapping("Statistics")
public class StatisticsController {
	
	@Autowired
	private RaceResultService raceResultService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("Statistics");
		return model;
	}
	
	@RequestMapping("listVenue")
	@ResponseBody
	public List<String> listVenue(){
		return raceResultService.listVenue();
	}
}
