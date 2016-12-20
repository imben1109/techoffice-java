package com.techoffice.oracle.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.fx.util.JavaFxTableViewUtil;
import com.techoffice.oracle.client.model.ChildTable;
import com.techoffice.oracle.client.model.ParentTable;
import com.techoffice.oracle.client.service.RelationService;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

@Component
public class RelationController {
	
	@Autowired
	private RelationService userTableService; 

	@FXML
	public TableView<ParentTable> parentTableView;
	
	@FXML
	public TableView<ChildTable> childTableView;
	
	@FXML
	public void initialize(){

	}
	
	public void setTableName(String tableName){
		List<ParentTable> dependentTableList = userTableService.getParentTableList(tableName);
		JavaFxTableViewUtil.tableViewSetBeanList(parentTableView, dependentTableList, ParentTable.class);
		
		List<ChildTable> childTableList = userTableService.getChildTableList(tableName);
		JavaFxTableViewUtil.tableViewSetBeanList(childTableView, childTableList, ChildTable.class);

	}
	
}
