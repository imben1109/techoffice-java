package com.techoffice.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.component.Test;

@Controller
@Scope("session")
public class HelloController {
	
	@Autowired
	private Test test;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model){
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}
	
	@ResponseBody
	@RequestMapping(value="/setName", method=RequestMethod.GET)
	public String setName(@RequestParam("name") String name){
		test.setName(name);
		return name;
	}
	
	@ResponseBody
	@RequestMapping(value="/getName", method=RequestMethod.GET)
	public String getName(HttpServletRequest request){
		HttpSession session = request.getSession();
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(name);
		}
		return test.getName();
	}
}
