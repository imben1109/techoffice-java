package com.techoffice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)  
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
	public Map<String, String> handleExample(HttpServletRequest req, Exception e){
    	e.printStackTrace();
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("exception", e.getMessage());
    	return map;
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)  
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleNotValidException(HttpServletRequest req, MethodArgumentNotValidException e){
    	Map<String, Object> map = new HashMap<String, Object>();
    	BindingResult bindingResult = e.getBindingResult();
    	List<String> errors = new ArrayList<String>();
    	List<FieldError> fieldErrors =bindingResult.getFieldErrors();
    	map.put("message", "Invalid Input");
    	map.put("fieldErrors", fieldErrors);
    	map.put("exception", e.getMessage());
    	return map;
    }
}
