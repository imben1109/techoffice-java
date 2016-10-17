package com.ittechoffice.example.control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.VBox;

/**
 * File Explorer Control
 * 
 * @author Ben_c
 *
 */
public class FxFileExplorer extends VBox {
	
	private String path;
	private FxFile selectedFile;
	private List<FxFile> fxFiles;
	private FxPath fxPath;
	
	public FxFileExplorer(String path){
		this.path = path;
		fxFiles = new ArrayList<FxFile>();
		init();
	}
	
	private void init(){
		fxPath = new FxPath(path);
		this.getChildren().add(fxPath);
		File dir = new File(path);
		File[] files = dir.listFiles();
		for(int i =0; i<files.length; i++){
			File file = files[i];
			System.out.println(file.getName());
			FxFile fxFile = new FxFile(file, this);
			fxFiles.add(fxFile);
			this.getChildren().add(fxFile);
		}
		
	}
	
	public void setSelectedFile(FxFile fxFile){
		if (selectedFile != null){
			selectedFile.unselect();
		}
		this.selectedFile = fxFile;
	}
	
	public void renameFile(){
		if (selectedFile != null){
			selectedFile.edit();
		}
	}
	
	public void nextFile(){
		if (selectedFile != null){
			int selectedIndex = this.fxFiles.indexOf(selectedFile);
			if (selectedIndex < this.fxFiles.size() -1 ){
				int index = selectedIndex + 1;
				FxFile fxFile = this.fxFiles.get(index);
				fxFile.select();
				setSelectedFile(fxFile);
			}
		}
	}
	
	public void previousFile(){
		if (selectedFile != null){
			int selectedIndex = this.fxFiles.indexOf(selectedFile);
			if (selectedIndex > 0 ){
				int index = selectedIndex - 1;
				FxFile fxFile = this.fxFiles.get(index);
				fxFile.select();
				setSelectedFile(fxFile);
			}
		}
	}
	
}
