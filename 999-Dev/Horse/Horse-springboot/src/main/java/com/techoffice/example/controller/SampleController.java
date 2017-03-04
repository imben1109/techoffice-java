package com.techoffice.example.controller;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String test() throws XPathExpressionException, XmlUtilDocumentConversionException, XmlUtilXpathNotUniqueException{
		currentOddService.run();
		return "";
	}
}