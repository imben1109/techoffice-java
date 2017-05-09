package com.techoffice.yahoo.finance.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.yahoo.finance.stock.service.PriceBatchService;

@Controller
@RequestMapping("HistoricalPriceBatch")
public class PriceBatchController {
	
	@Autowired
	private PriceBatchService priceBatchService;
	
	@RequestMapping("run")
	@ResponseBody
	public String run(){
		priceBatchService.run();
		return "run";
	}
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("priceBatch");
//		List<Stock> stocks = stockService.list();
//		model.addObject("stocks", stocks);
		return model;
	}
	
}
