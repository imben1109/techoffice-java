package com.techoffice.yahoo.finance.boot.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.util.exception.XmlUtilInvalidDocumentException;
import com.techoffice.yahoo.finance.stock.model.HsiStock;
import com.techoffice.yahoo.finance.stock.service.HsiStockService;

@Controller
@RequestMapping("HsiStock")
public class HsiStockController {
	
	@Autowired
	private HsiStockService hsiStockService;
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("hsiStock");
		List<HsiStock> hsiStocks = hsiStockService.list();
		model.addObject("hsiStocks", hsiStocks);
		return model;
	}
	
	@RequestMapping("/updateHsiStockList")
	@ResponseBody
	public String updateHsiStockList() throws XPathExpressionException, XmlUtilInvalidDocumentException{
		hsiStockService.updateHsiStockList();
		return "completed";
	}
	
	@RequestMapping("/updateHsi")
	@ResponseBody
	public String updateHsi() throws IllegalAccessException, InvocationTargetException, IOException{
		hsiStockService.updateHsi();
		return "completed";
	}
}
