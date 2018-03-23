package com.techoffice.controller;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model){
		model.addAttribute("message", "Spring 3 MVC Hello World");
		log.info("HelloWorld");
		return "hello";
	}
	
	@ResponseBody
	@RequestMapping(value="/sayhi", method=RequestMethod.GET)
	public String sayHi(){
		return "Hi!";
	}
}
