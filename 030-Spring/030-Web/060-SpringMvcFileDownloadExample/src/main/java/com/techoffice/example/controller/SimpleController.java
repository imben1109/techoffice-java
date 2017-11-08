package com.techoffice.example.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model){
		return "home";
	}

	/**
	 * The upload file would be mapped to MultipartFile for further processing
	 * @param file
	 * @return view name 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/fileDownload", method = RequestMethod.GET)
	@ResponseBody
	public byte[] fileDownload() throws IOException{
		return null;
	}
	

}
