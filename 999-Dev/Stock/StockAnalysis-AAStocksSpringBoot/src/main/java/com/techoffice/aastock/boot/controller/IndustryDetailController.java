package com.techoffice.aastock.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.aastock.stock.model.IndustryDetail;
import com.techoffice.aastock.stock.service.IndustryDetailService;
import com.techoffice.util.exception.WebCrawlerException;

@Controller
@RequestMapping("IndustryDetail")
public class IndustryDetailController {
	
	@Autowired
	private IndustryDetailService industryDetailService;
	
	@RequestMapping("/{industrySymbol}")
	public ModelAndView home(@PathVariable(name="industrySymbol", required=true ) String industrySymbol ){
		ModelAndView model = new ModelAndView("IndustryDetail");
		List<IndustryDetail> industryDetails = industryDetailService.list(industrySymbol);
		model.addObject("industryDetails", industryDetails);
		return model;
	}
	
	@RequestMapping("/update/{industrySymbol}")
	@ResponseBody
	public String update(@PathVariable(name="industrySymbol") String industrySymbol) throws WebCrawlerException{
		industryDetailService.updateIndustryDetail(industrySymbol);
		return "updated";
	}
}
