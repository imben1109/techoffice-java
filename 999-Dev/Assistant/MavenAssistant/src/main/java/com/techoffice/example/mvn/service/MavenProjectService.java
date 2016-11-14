package com.techoffice.example.mvn.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.example.mvn.constant.MavenConstant;
import com.techoffice.example.mvn.model.Model;
import com.techoffice.example.mvn.util.MavenProjectHelper;
import com.techoffice.example.mvn.util.PomUtil;

public class MavenProjectService {
	
	public List<File> getMavenProjectList(String path){
		System.out.println("Finding Maven Project in " + path);
		List<File> mavenProjectList = new ArrayList<File>();
		File root = new File(path);
		mavenProjectList = getMavenProjectList(root);
		System.out.println("Found " + mavenProjectList.size() + " Maven Projects");
		return mavenProjectList;
	}
	
	public List<Model> getMavenProjectModelList(String path) throws Exception{
		List<File> modelProjectList = getMavenProjectList(path);
		List<Model> modelList =  getMavenProjectModelList(modelProjectList);
		return modelList;
	}
	
	public List<Model> getMavenProjectModelList(List<File> mavenProjectFileList) throws Exception{
		List<Model> modelList = new ArrayList<Model>();
		for (File mavenProjectFile: mavenProjectFileList){
			File pomFile = new File(mavenProjectFile.getPath(), MavenConstant.POM_FILE);
			Model model = PomUtil.getModel(pomFile.getPath());
			modelList.add(model);
		}
		return modelList;
	}
	
	private List<File> getMavenProjectList(File root){
		List<File> mavenProjectList = new ArrayList<File>();
		File[] files = root.listFiles();
		for (int i=0; i<files.length; i ++){
			File file = files[i];
			if (file.isDirectory()){
				if (MavenProjectHelper.isMavenProject(file)){
					mavenProjectList.add(file);
				}else{
					mavenProjectList.addAll(getMavenProjectList(file));
				}
			}
		}
		return mavenProjectList;
	}
}
