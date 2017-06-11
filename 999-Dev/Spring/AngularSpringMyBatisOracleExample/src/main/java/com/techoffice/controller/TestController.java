package com.techoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.entity.TestForm;
import com.techoffice.model.Test;
import com.techoffice.service.TestService;

@RequestMapping("/Test")
@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/search")
	@ResponseBody
	public List<Test> search(@RequestBody(required=false) TestForm testForm){
		return testService.search();
	}
	
	
}
