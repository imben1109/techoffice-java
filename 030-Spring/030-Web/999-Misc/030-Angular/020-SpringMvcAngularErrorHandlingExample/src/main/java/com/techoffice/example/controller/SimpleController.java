package com.techoffice.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.example.exception.ExampleException;

@Controller
public class SimpleController {
	
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String hello(ModelMap model){
		return "home";
	}
	
	@RequestMapping(value = "/getString", method = {RequestMethod.GET, RequestMethod.POST},
			produces= {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public HttpEntity<String> getString(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new HttpEntity<String>("Test", headers);
	}
	
	@RequestMapping(value = "/getStringWithError", method = {RequestMethod.GET, RequestMethod.POST},
			produces= {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public HttpEntity<String>  getStringWithError(){
		if (true){
			throw new ExampleException("Failed to do something");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new HttpEntity<String>("Test", headers);
	}
	
	@RequestMapping(value = "/getMap", method = {RequestMethod.GET, RequestMethod.POST},
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public Map<String, String> getMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		return map;
	}
	
	@RequestMapping(value = "/getMapWithError", method = {RequestMethod.GET, RequestMethod.POST},
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public Map<String, String> getMapWithError(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		if (true){
			throw new ExampleException("Failed to do something");
		}
		return map;
	}
	

}
