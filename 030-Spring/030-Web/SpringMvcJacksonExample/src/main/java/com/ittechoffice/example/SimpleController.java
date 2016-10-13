package com.ittechoffice.example;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
	
	/**
	 * Handle request from root
	 * produces = "application/json": it would make the context to be "application/json"
	 * @return user, User for Json Object
	 */
	@RequestMapping(value="/", produces = "application/json")
	@ResponseBody
	public User home(){
		User user = new User();
		user.setName("Test Name");
		user.setDob(new Date());
		return user;	
	}
	
}
