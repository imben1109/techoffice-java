package com.techoffice.jc.boot.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.jc.horse.model.RaceDate;
import com.techoffice.jc.horse.service.RaceDateService;
import com.techoffice.util.exception.DocumentConversionException;
import com.techoffice.util.exception.XpathException;

@Controller
@RequestMapping("RaceDate")
public class RaceDateController {

	@Autowired
	private RaceDateService raceDateService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("RaceDate");
		List<RaceDate> raceDates = raceDateService.list();
		view.addObject("raceDates", raceDates);
		return view;
	}
	
	@RequestMapping("updateRaceDateList")
	@ResponseBody
	public Map<String, Integer> updateRaceDateList() throws XpathException, ParseException {
		return raceDateService.updateRaceDateList();
	}

	@RequestMapping("pendingRaceDateList")
	@ResponseBody
	public Map<String, Object> pendingQueueDateList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<RaceDate> raceDateList = raceDateService.getPendingRaceDateList();
		map.put("list", raceDateList);
		map.put("count", raceDateList.size());
		return map;
	}
	
	@RequestMapping("updateRaceResultQueues")
	@ResponseBody
	public Map<String, Integer> updateRaceResultQueues() throws XpathException, ParseException {
		return raceDateService.updateRaceResultQueues();
	}
	
	@RequestMapping("/RaceDateDetail")
	public ModelAndView raceDateDetail(
			@RequestParam("raceDate") 
			@DateTimeFormat(pattern="ddMMyyyy") 
			Date raceDate){
		ModelAndView view = new ModelAndView("RaceDateDetail");
		
		return view;
	}
	
}
