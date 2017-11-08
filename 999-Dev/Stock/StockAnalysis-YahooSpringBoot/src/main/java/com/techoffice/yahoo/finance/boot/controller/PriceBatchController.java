package com.techoffice.yahoo.finance.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.yahoo.finance.stock.exception.PriceBatchJobException;
import com.techoffice.yahoo.finance.stock.model.PriceBatch;
import com.techoffice.yahoo.finance.stock.service.PriceBatchService;

@Controller
@RequestMapping("PriceBatch")
public class PriceBatchController {
	
	@Autowired
	private PriceBatchService priceBatchService;
	
	@RequestMapping("run")
	@ResponseBody
	public String run() throws PriceBatchJobException{
		priceBatchService.run();
		return "run";
	}
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("priceBatch");
		List<PriceBatch> priceBatchList = priceBatchService.list();
		model.addObject("priceBatchList", priceBatchList);
		return model;
	}
	
}
