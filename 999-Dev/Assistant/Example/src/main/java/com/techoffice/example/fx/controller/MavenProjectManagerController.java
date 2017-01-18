package com.techoffice.example.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techoffice.example.ExampleProperty;
import com.techoffice.example.mvn.MavenProjectManager;
import com.techoffice.example.mvn.pom.model.Model;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

@Controller
public class MavenProjectManagerController implements Initializable {
	
	private final Logger logger = Logger.getLogger(this.getClass());
	
	@FXML
	private Label numMvnProjLabel;
	
	@FXML
	private Label numInvalidMvnProjLabel;
	
	@FXML
	private Label validMvnProjLogLabel;
	
	@FXML
	private TableView<Model> tableView;
	
	@Autowired
	private MavenProjectManager mavenProjectManager;
	
	public void initialize(URL fxmlFileLocation, ResourceBundle resources){
			int numMvnProj = mavenProjectManager.getNumMvnProj();
			int numInvalidMvnProj = mavenProjectManager.getNumInvalidMvnProj();
			numMvnProjLabel.setText(Integer.toString(numMvnProj));
			numInvalidMvnProjLabel.setText(Integer.toString(numInvalidMvnProj));

	}
	
    @FXML
    private void validMvnProj(){
    	try {
			mavenProjectManager.correctInvalidMavenProject();
			int numMvnProj = mavenProjectManager.getNumMvnProj();
			numMvnProjLabel.setText(Integer.toString(numMvnProj));	
			int numInvalidMvnProj = mavenProjectManager.getNumInvalidMvnProj();
			numInvalidMvnProjLabel.setText(Integer.toString(numInvalidMvnProj));
			
			validMvnProjLogLabel.setText("Completed");
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    }
    
    @FXML
    private void loadProjInfo(){
		try {
			tableView.getItems().addAll(mavenProjectManager.getProjectModelList());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    }

}
