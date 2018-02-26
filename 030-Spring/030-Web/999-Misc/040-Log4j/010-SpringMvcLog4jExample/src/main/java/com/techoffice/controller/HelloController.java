package com.techoffice.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	private Logger logger = LogManager.getLogger(HelloController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model){
		logger.info("testing");
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}
	
	@ResponseBody
	@RequestMapping(value="/sayhi", method=RequestMethod.GET)
	public String sayHi(){
		logger.info("testing");
		return "Hi!";
	}
}
