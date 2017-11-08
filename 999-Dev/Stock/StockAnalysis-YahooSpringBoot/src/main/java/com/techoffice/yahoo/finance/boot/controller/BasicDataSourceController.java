package com.techoffice.yahoo.finance.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.util.service.BasicDataSourceService;

@Controller
@RequestMapping("/BasicDataSource")
public class BasicDataSourceController {
	
	@Autowired
	private BasicDataSourceService basicDataSourceService;
	
	@RequestMapping("/")
	@ResponseBody
	public Map<String, String> home(){
		Map<String, String> map = new HashMap<String, String>();
		int numActive = basicDataSourceService.getNumActive();
		int numIdle = basicDataSourceService.getNumIdle();
		int maxActive = basicDataSourceService.getMaxActive();
		map.put("numActive", Integer.toString(numActive));
		map.put("numIdle", Integer.toString(numIdle));
		map.put("maxActive", Integer.toString(maxActive));
		return map;
	}
}
