package com.techoffice.example.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.hkex.stock.model.Stock;
import com.techoffice.hkex.stock.service.StockService;
import com.techoffice.util.exception.XmlUtilInvalidDocumentException;

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
	
	@RequestMapping("updateFromInternet")
	@ResponseBody
	public String updateFromInternet() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilInvalidDocumentException{
		stockService.updateFromInternet();
		return "completed";
	}
	
}
