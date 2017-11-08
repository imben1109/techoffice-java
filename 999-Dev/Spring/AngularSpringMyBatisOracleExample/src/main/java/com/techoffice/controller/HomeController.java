package com.techoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	/**
	 * Handle request from root
	 */
	@RequestMapping(value="/", produces = "application/json")
	@ResponseBody
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
}
