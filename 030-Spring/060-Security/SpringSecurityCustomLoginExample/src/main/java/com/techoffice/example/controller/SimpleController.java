package com.techoffice.example.controller;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
	
	@RequestMapping(value="/")
	@ResponseBody
	public String home(){
		return "Hello Spring Sercurity Web Application";
	}
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/logoutPage")
	public String logout(){
		return "logoutPage";
	}
	
	@ResponseBody
	@RequestMapping(value="/access")
	public String access(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null){
			System.out.println(authentication.getName() + ": authenticated" );
		}else{
			System.out.println("not authenticated");
		}
		return "access";
	}
	
	
}

