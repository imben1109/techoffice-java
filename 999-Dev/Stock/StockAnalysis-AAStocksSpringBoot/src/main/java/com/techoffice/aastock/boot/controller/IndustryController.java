package com.techoffice.aastock.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.aastock.stock.model.Industry;
import com.techoffice.aastock.stock.service.IndustryService;
import com.techoffice.util.exception.WebCrawlerException;

@Controller
@RequestMapping("Industry")
public class IndustryController {
	
	@Autowired
	private TaskExecutor taskExecutor; 
	
	@Autowired
	private IndustryService industryService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("Industry");
		List<Industry> industryList = industryService.list();
		view.addObject("industryList", industryList);
		return view;
	}
	
	@RequestMapping("updateIndustryList")
	@ResponseBody
	public String updateIndustryList() throws WebCrawlerException{
		industryService.updateIndustry();
		return "completed";
	}
	
	@RequestMapping("updateIndustryDetails")
	@ResponseBody
	public String updateIndustryDetails() throws WebCrawlerException{
		taskExecutor.execute(new Runnable(){
			@Override
			public void run() {
				try {
					industryService.updateIndustryDetails();
				} catch (WebCrawlerException e) {
					e.printStackTrace();
				}		
			}
		});
		return "completed";
	}
}
