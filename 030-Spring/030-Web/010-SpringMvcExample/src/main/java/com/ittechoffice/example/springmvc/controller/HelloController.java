package com.ittechoffice.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model){
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}
	
	@ResponseBody
	@RequestMapping(value="/sayhi", method=RequestMethod.GET)
	public String sayHi(){
		return "Hi!";
	}
}
