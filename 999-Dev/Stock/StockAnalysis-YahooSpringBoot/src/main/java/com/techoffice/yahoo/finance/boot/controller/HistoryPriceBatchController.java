package com.techoffice.yahoo.finance.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.yahoo.finance.stock.service.HistoryPriceBatchService;

@Controller
@RequestMapping("HistoryPriceBatch")
public class HistoryPriceBatchController {
	
	@Autowired
	private HistoryPriceBatchService historyPriceBatchService;
	
	@RequestMapping("run")
	@ResponseBody
	public String run(){
		historyPriceBatchService.run();
		return "run";
	}
	
}
