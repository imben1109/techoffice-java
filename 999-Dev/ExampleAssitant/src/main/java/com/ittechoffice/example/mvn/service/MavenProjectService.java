package com.ittechoffice.example.mvn.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ittechoffice.example.mvn.constant.MavenProjectContant;
import com.ittechoffice.example.mvn.util.MavenProjectHelper;

public class MavenProjectService {
	
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
	
	public List<File> getMavenProjectList(String path){
		System.out.println("Finding Maven Project in " + path);
		List<File> mavenProjectList = new ArrayList<File>();
		File root = new File(path);
		mavenProjectList = getMavenProjectList(root);
		System.out.println("Found " + mavenProjectList.size() + " Maven Projects");
		return mavenProjectList;
	}
	
	public List<File> getInvalidMavenProjectList(List<File> mavenProjectList){
		List<File> invalidMavenProjectList = new ArrayList<File>();
		for(File mavenProject: mavenProjectList){
			if (MavenProjectHelper.isMissingGitKeep(mavenProject)){
				invalidMavenProjectList.add(mavenProject);
			}
		}
		return invalidMavenProjectList;
	}
	
	public void correctInvalidMavenProject(List<File> invalidMvnProjList) throws IOException{
		for (File file: invalidMvnProjList){
			File mainResources = new File(file.getPath() + MavenProjectContant.MAIN_RESOURCES_GITKEEP);
			File mainFolder = new File(file.getPath() + "/src/main");
			File mainResourcesFolder = new File(file.getPath() + "/src/main/resources");

			File testFolder = new File(file.getPath() + "/src/test");
			File testJavaFolder = new File(file.getPath() + "/src/test/java");
			File testResourcesFolder = new File(file.getPath() + "/src/test/resources");
			File testJava = new File(file.getPath() + "/src/test/java/.gitkeep");
			File testResources = new File(file.getPath() + "/src/test/resources/.gitkeep");
			
			if (!mainFolder.exists()){
				mainFolder.mkdirs();
			}
			
			if (!mainResourcesFolder.exists()){
				mainResourcesFolder.mkdirs();
			}
			
			if (!mainResources.exists()){
				System.out.println(mainResources.getPath() + " created");
				mainResources.createNewFile();
			}
			
			if (!testFolder.exists()){
				testFolder.mkdirs();
			}
			
			if (!testJavaFolder.exists()){
				testJavaFolder.mkdirs();
			}
			
			if (!testResourcesFolder.exists()){
				testResourcesFolder.mkdirs();
			}
			
			if (!testJava.exists()){
				System.out.println(testJava.getPath() + " created");
				testJava.createNewFile();
			}
			
			if (!testResources.exists()){
				System.out.println(testResources.getPath() + " created");
				testResources.createNewFile();
			}
		}
	}
	
	public List<File> getDummyFileList(List<File> mavenProjectList){
		List<File> dummyFileList = new ArrayList<File>();
		for(File file: mavenProjectList){
			if(MavenProjectHelper.isTargetClassExist(file)){
				dummyFileList.add(new File(file.getPath(), MavenProjectContant.TARGET_CLASSES));
			}
		}
		return dummyFileList;
	}
}
