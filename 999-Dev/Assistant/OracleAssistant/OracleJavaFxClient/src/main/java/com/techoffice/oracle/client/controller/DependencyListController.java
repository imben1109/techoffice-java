package com.techoffice.oracle.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.fx.util.JavaFxTableViewUtil;
import com.techoffice.oracle.client.model.ParentTable;
import com.techoffice.oracle.client.service.SqlService;
import com.techoffice.oracle.client.service.UserTableService;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

@Component
public class DependencyListController {
	
	@Autowired
	private SqlService sqlService;
	
	@Autowired
	private UserTableService userTableService; 

	@FXML
	public TableView<ParentTable> tableView;
	
	@FXML
	public void initialize(){

	}
	
	public void setTableName(String tableName){
		List<ParentTable> dependentTableList = userTableService.getDependentTableList(tableName);
		JavaFxTableViewUtil.tableViewSetBeanList(tableView, dependentTableList, ParentTable.class);
	}
	
}
