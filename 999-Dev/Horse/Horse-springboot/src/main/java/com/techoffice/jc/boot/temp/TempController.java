package com.techoffice.jc.boot.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Temp")
public class TempController {
	
	@Autowired
	private TempService tempService;
	
	@RequestMapping("run")
	@ResponseBody
	public String run(){
		tempService.run();
		return "";
	}
}
