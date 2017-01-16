package com.techoffice.hkex.javafx.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.hkex.stock.model.Stock;
import com.techoffice.hkex.stock.service.StockService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
 
@Component
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@FXML
	private TableView<Stock> tableView;
	
	@FXML
	public void initialize(){
		tableView.getItems().addAll(stockService.getStockList());
	}
	
	@FXML
	public void refresh(ActionEvent event) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		stockService.updateFromInternet();
		tableView.getItems().clear();
		tableView.getItems().addAll(stockService.getStockList());
	}
	
	@FXML
	public void export(ActionEvent event){
		
	}
	
}
