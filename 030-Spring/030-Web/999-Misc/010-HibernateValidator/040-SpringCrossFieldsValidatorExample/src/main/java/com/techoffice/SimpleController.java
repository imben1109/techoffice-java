package com.techoffice;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.model.User;

@Controller
public class SimpleController {
	
	/**
	 * Handle request from root
	 * produces = "application/json": it would make the context to be "application/json"
	 * @return user, User for Json Object
	 */
	@RequestMapping(value="/", produces = "application/json")
	public String home(){
		return "/hello";
	}
	
	@RequestMapping("request")
	@ResponseBody
	public User request(@Valid @RequestBody User user){
		return user;	
	}
}
