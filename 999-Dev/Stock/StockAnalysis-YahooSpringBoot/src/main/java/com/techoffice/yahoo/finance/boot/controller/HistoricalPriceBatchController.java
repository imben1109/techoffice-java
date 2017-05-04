package com.techoffice.yahoo.finance.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.yahoo.finance.stock.service.HistoryPriceBatchService;

@Controller
@RequestMapping("HistoricalPriceBatch")
public class HistoricalPriceBatchController {
	
	@Autowired
	private HistoryPriceBatchService historyPriceBatchService;
	
	@RequestMapping("run")
	@ResponseBody
	public String run(){
		historyPriceBatchService.run();
		return "run";
	}
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("historicalPriceBatch");
//		List<Stock> stocks = stockService.list();
//		model.addObject("stocks", stocks);
		return model;
	}
	
}
