package com.techoffice.jc.springboot.controller;

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
public class IndexController {
    
	@Autowired
	private CurrentOddService currentOddService;
	
	@RequestMapping("/")
	public String index() {
        return "welcome";
    }

	@RequestMapping("/currentAnalysis")
	@ResponseBody
	public Map<String, List<CurrentOdd>> test() throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		Map<String, List<CurrentOdd>> map = currentOddService.getCurrentOddMap();
		return map;
	}
	

}