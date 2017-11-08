package com.techoffice.yahoo.finance.boot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.util.service.JobExplorerService;

@RequestMapping("JobExplorer")
@Controller
public class JobExplorerController {

	@Autowired
	private JobExplorerService jobExplorerService;
	
	@RequestMapping("jobs")
	@ResponseBody
	public Map<String, String> getJobs(){
		return jobExplorerService.getJobs();
	}
	
}
