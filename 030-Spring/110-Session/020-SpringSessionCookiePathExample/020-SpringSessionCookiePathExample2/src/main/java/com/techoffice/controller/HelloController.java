package com.techoffice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/")
@Controller
public class HelloController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model, HttpSession session){
		model.addAttribute("message", session.getAttribute("testing"));
		session.setAttribute("testing", "testing2");
		return "hello";
	}
	
	@ResponseBody
	@RequestMapping(value="/sayhi", method=RequestMethod.GET)
	public String sayHi(){
		return "Hi!";
	}
}
