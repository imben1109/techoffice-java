package com.techoffice.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.example.example.FeNotFolderException;
import com.techoffice.example.model.FeFile;
import com.techoffice.example.service.FileExploerService;

@Controller
@RequestMapping("/fileExplorer")
public class FileExploerController {
	
	@Autowired
	private FileExploerService fileExploerService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<FeFile> list(@RequestParam String parent) throws FeNotFolderException{
		return fileExploerService.list(parent);
	}
}
