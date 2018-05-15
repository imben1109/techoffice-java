package com.techoffice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.criteria.TestCriteria;
import com.techoffice.entity.Test;
import com.techoffice.key.TestKey;
import com.techoffice.service.TestService;


@Controller
@RequestMapping(value = "/test")
public class TestController{
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Test> search(){
		TestCriteria testCiteria = new TestCriteria();
		return testService.search(testCiteria);
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Test find(@Valid @RequestBody TestKey testKey){
		return testService.find(testKey);
	}
	
	@RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void insert(@Valid @RequestBody Test test){
		testService.insert(test);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void update(@Valid @RequestBody Test test){
		testService.update(test);
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void delete(@Valid @RequestBody TestKey testKey){
		testService.delete(testKey);
	}

}