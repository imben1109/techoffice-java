package com.techoffice.oracle.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.oracle.client.model.Column;
import com.techoffice.oracle.client.model.EntityTable;
import com.techoffice.oracle.client.service.EntityService;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

@Component
public class EntityController {
	
	@Autowired
	private EntityService entityService;
	
	@FXML
	private TableView<EntityTable> entityTableView;
	
	@FXML
	public void initialize(){
	}
	
	public void init(String tableName){
		List<Column> results = entityService.getTableColumnList(tableName);
	}
}
