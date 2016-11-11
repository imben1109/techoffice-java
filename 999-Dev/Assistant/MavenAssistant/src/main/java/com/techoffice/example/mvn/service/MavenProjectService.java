package com.techoffice.example.mvn.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.example.mvn.util.MavenProjectHelper;

public class MavenProjectService {
	
	public List<File> getMavenProjectList(String path){
		System.out.println("Finding Maven Project in " + path);
		List<File> mavenProjectList = new ArrayList<File>();
		File root = new File(path);
		mavenProjectList = getMavenProjectList(root);
		System.out.println("Found " + mavenProjectList.size() + " Maven Projects");
		return mavenProjectList;
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
