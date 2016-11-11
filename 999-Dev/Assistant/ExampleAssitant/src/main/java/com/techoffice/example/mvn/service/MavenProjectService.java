package com.techoffice.example.mvn.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.example.mvn.constant.MavenProjectContant;
import com.techoffice.example.mvn.util.MavenProjectHelper;
import com.techoffice.example.util.FileUtil;

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
			File mainFolder = new File(file.getPath() + "/src/main");
			File mainResourcesFolder = new File(file.getPath() + "/src/main/resources");
			File testFolder = new File(file.getPath() + "/src/test");
			File testJavaFolder = new File(file.getPath() + "/src/test/java");
			File testResourcesFolder = new File(file.getPath() + "/src/test/resources");
			FileUtil.createFolderIfNotExist(mainFolder);
			FileUtil.createFolderIfNotExistWithGitKeep(mainResourcesFolder);
			FileUtil.createFolderIfNotExist(testFolder);
			FileUtil.createFolderIfNotExistWithGitKeep(testJavaFolder);
			FileUtil.createFolderIfNotExistWithGitKeep(testResourcesFolder);
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
