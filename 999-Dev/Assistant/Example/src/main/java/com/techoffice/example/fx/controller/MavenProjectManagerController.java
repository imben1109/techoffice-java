package com.techoffice.example.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techoffice.example.mvn.MavenProjectManager;
import com.techoffice.example.mvn.pom.model.Model;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	
	@FXML
	private Button validMvnProjBtn;
	
	@FXML
	private Button loadProjInfo;
	
	@Autowired
	private MavenProjectManager mavenProjectManager;
	
	public void initialize(URL fxmlFileLocation, ResourceBundle resources){
			int numMvnProj = mavenProjectManager.getNumMvnProj();
			int numInvalidMvnProj = mavenProjectManager.getNumInvalidMvnProj();
			numMvnProjLabel.setText(Integer.toString(numMvnProj));
			numInvalidMvnProjLabel.setText(Integer.toString(numInvalidMvnProj));

	}
	
    @FXML
    public void validMvnProj(){
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
    public void loadProjInfo(){
		try {
			Callable<String> caller = new Callable<String>(){
				public String call()  {
					try {
						loadProjInfo.setDisable(true);
						mavenProjectManager.updateMavenProjectList();
						tableView.getItems().addAll(mavenProjectManager.getProjectModelList());
						loadProjInfo.setDisable(false);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "done";
				}
			};

			ExecutorService executorService = Executors.newSingleThreadExecutor();
			executorService.submit(caller);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    }

}
