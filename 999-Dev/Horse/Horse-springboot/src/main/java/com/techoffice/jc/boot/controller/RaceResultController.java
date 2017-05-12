package com.techoffice.jc.boot.controller;

import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.service.RaceResultService;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

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
	
}
