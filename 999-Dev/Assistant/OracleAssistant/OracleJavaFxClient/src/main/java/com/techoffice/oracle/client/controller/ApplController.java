package com.techoffice.oracle.client.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.javafx.util.JavaFxUtil;
import com.techoffice.oracle.client.service.ApplService;
import com.techoffice.oracle.client.util.SqlUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

@Component
public class ApplController {
	
	@Autowired
	private ApplService applService;
	
	@FXML
	private TextArea sqlTextArea;
	
	@FXML
	private TableView tableView;
	
	private boolean isCtrlPressed = false;

	@FXML
	public void initialize(){
	}
	
	@FXML
	public void executeSql(){
		String formatSql = SqlUtil.formatSql(sqlTextArea.getText());
		if (!StringUtils.isEmpty(formatSql)){
			List<Map<String, Object>> results = applService.executeSql(formatSql);
			JavaFxUtil.setTableView(tableView, results);
		}
	}
	
	@FXML
	public void tableRelationShip(){
		System.out.println("Table Relationship");
	}
	
	
	@FXML
	public void handleSqlTextAreaKeyPressedEvent(KeyEvent event){
		if (event.getCode() == KeyCode.CONTROL){
			isCtrlPressed = true;
		}
		if (isCtrlPressed){
			if (event.getCode() == KeyCode.ENTER){
				executeSql();
			}
		}
	}
	
	@FXML
	public void handleSqlTextAreaKeyReleasedEvent(KeyEvent event){
		if (event.getCode() == KeyCode.CONTROL){
			isCtrlPressed = false;
		}	
	}
}
