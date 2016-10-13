package com.ittechoffice.example.springmvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile file, ModelMap map) throws IOException{
		
		// Create Temporary File for storing uploaded file.
		File tmpFile = File.createTempFile(file.getOriginalFilename(), null);
		tmpFile.deleteOnExit();
		file.transferTo(tmpFile);
		System.out.println("Temporary File Name: " + tmpFile.getName());
		System.out.println("Temporary File Path: " + tmpFile.getPath());
		
		map.put("uploadedFilename", file.getOriginalFilename());
		map.put("tmpFileName", tmpFile.getName());
		map.put("tmpFilePath", tmpFile.getPath());
		
		return "fileUpload";
	}
	

}
