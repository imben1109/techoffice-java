package com.techoffice.jc.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.jc.horse.service.RaceResultQueueBatchService;

@Controller
@RequestMapping("RaceResultQueueBatch")
public class RaceResultQueueBatchController {

	@Autowired
	private RaceResultQueueBatchService raceResultQueueBatchService;

	@RequestMapping("executeResultQueueList")
	@ResponseBody
	public String executeResultQueueList(){
		raceResultQueueBatchService.executeResultQueues();
		return "completed";
	}
	
	
}
