package com.techoffice.aastock.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.hkex.csvimport.stock.model.Stock;
import com.techoffice.hkex.csvimport.stock.service.StockService;

@Controller
@RequestMapping("stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("stock");
		List<Stock> stocks = stockService.list();
		model.addObject("stocks", stocks);
		return model;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> list(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Stock> stocks = stockService.list();
		map.put("result", stocks);
		map.put("count", stocks.size());
		return map;
	}
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	@ResponseBody
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
		File uploadTempFile = File.createTempFile(file.getName(), "");
		file.transferTo(uploadTempFile);
		stockService.updateStockList(uploadTempFile);
		return "uploaded";
	}
	
	@RequestMapping("test")
	@ResponseBody
	public String test(){
		return "test";
	}
	
}
