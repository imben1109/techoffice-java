package com.techoffice.oracle.client.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.javafx.util.JavaFxUtil;
import com.techoffice.oracle.client.service.ApplService;
import com.techoffice.oracle.client.util.SqlUtil;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

@Component
public class ApplController {
	
	@Autowired
	private ApplService applService;
	
	@FXML
	private TextArea sqlTextArea;
	
	@FXML
	private TableView tableView;

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
	
}
