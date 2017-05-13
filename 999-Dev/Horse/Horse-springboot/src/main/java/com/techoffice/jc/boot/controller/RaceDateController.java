package com.techoffice.jc.boot.controller;

import java.text.ParseException;
import java.util.Date;
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
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

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
	
	@RequestMapping("/updateRaceDateList")
	@ResponseBody
	public Map<String, Integer> updateRaceDateList() throws XPathExpressionException, XmlUtilDocumentConversionException, ParseException{
		return raceDateService.updateRaceDateList();
	}

	@RequestMapping("pendingQueueDateList")
	@ResponseBody
	public Map<String, Object> pendingQueueDateList(){
		return raceDateService.getPendingQueueDateList();
	}
	
	@RequestMapping("processRaceResultQueueList")
	@ResponseBody
	public Map<String, Integer> processRaceResultQueueList() throws XPathExpressionException, XmlUtilDocumentConversionException, ParseException{
		return raceDateService.processRaceResultQueueList();
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
