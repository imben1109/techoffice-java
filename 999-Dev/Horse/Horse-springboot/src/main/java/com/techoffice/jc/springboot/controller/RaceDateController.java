package com.techoffice.jc.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Map<String, Integer> updateRaceDateList() throws XPathExpressionException, XmlUtilDocumentConversionException{
		return raceDateService.updateRaceDateList();
	}
}
