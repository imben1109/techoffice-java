package com.techoffice.example.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleAllException(Exception ex) {
		return "Exception Occurs: " + ex.getMessage();
	}
	
}
