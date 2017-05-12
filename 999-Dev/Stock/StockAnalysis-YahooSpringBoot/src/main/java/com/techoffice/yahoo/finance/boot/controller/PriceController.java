package com.techoffice.yahoo.finance.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.yahoo.finance.stock.model.Price;
import com.techoffice.yahoo.finance.stock.service.PriceService;

@Controller
@RequestMapping("Price")
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	
	@RequestMapping(value="list/{stockNo}")
	public ModelAndView list(@PathVariable(name="stockNo", required=true) String stockNo){
		ModelAndView model = new ModelAndView("price");
		model.addObject("stockNo", stockNo);
		if (stockNo.length() > 3){
			stockNo = stockNo.substring(stockNo.length() - 4);
			List<Price> prices = priceService.list(stockNo);
			model.addObject("prices", prices);
		}
		return model;
	}
}
