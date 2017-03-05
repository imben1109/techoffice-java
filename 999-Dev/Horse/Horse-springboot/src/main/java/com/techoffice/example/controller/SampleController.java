package com.techoffice.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.jc.horse.service.CurrentOddService;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

@Controller
public class SampleController {
    
	@Autowired
	private CurrentOddService currentOddService;
	
	@RequestMapping("/")
	public String home() {
        return "welcome";
    }

	@RequestMapping("/test")
	@ResponseBody
	public Map<String, List<CurrentOdd>> test() throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		Map<String, List<CurrentOdd>> map = currentOddService.getCurrentOddMap();
		return map;
	}
	
	@RequestMapping("/map")
	@ResponseBody
	public Map<String, String> getMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("Test1", "Testing Value 1");
		map.put("Test2", "Testing Value 2");
		return map;
	}
}