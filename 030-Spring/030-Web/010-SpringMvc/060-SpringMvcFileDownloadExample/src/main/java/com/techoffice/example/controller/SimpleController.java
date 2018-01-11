package com.techoffice.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
	
	@RequestMapping(value = "/getMap", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		return map;
	}

	
	@RequestMapping(value = "/byteArrFileDownload", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public byte[] byteArrFileDownload() throws IOException{
		File file = File.createTempFile("test", ".txt");
		file.deleteOnExit();
		List<String> lines = new ArrayList<String>();
		lines.add("testing");
		FileUtils.writeLines(file, lines);
		return FileUtils.readFileToByteArray(file);
	}
	
	@RequestMapping(value = "/httpEntityFileDownload", method = {RequestMethod.GET, RequestMethod.POST}, 
			produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public HttpEntity<byte[]> httpEntityFileDownload() throws IOException{
		File file = File.createTempFile("test", ".txt");
		file.deleteOnExit();
		List<String> lines = new ArrayList<String>();
		lines.add("testing");
		FileUtils.writeLines(file, lines);
		byte[] byteArr =  FileUtils.readFileToByteArray(file);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", file.getName());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new HttpEntity<byte[]>(byteArr, headers);
	}
	

}
