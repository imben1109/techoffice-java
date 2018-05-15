package com.techoffice.generator.project;

import java.io.File;

import com.techoffice.generator.project.base.ProjectGenerator;
import com.techoffice.generator.project.config.ProjectConfig;

public class FolderStructureGenerator implements ProjectGenerator {

	@Override
	public File generate() {
		File projectFolder = new File(ProjectConfig.getProjectPath(), ProjectConfig.getProjectName());
		projectFolder.mkdir();
		
		File srcFolder = new File(projectFolder, "src");
		srcFolder.mkdir();
		
		File mainFolder = new File(srcFolder, "main");
		mainFolder.mkdir();
		
		File mainJavaFolder = new File(mainFolder, "java");
		mainJavaFolder.mkdir();
		
		File mainResourcesFolder = new File(mainFolder, "resources");
		mainResourcesFolder.mkdir();
		
		File testFolder = new File(srcFolder, "test");
		mainFolder.mkdir();
		
		File testJavaFolder = new File(testFolder, "java");
		testJavaFolder.mkdir();
		
		File testResourcesFolder = new File(testFolder, "resources");
		testResourcesFolder.mkdir();
		
		File webappFolder = new File(srcFolder, "webapp");
		webappFolder.mkdir();
		
		File webappWebinfFolder = new File(webappFolder, "WEB-INF");
		webappWebinfFolder.mkdir();
		
		File webappMetainfFolder = new File(webappFolder, "META-INF");
		webappMetainfFolder.mkdir();
		
		return projectFolder;
	}

	public static void main(String[] args){
		FolderStructureGenerator FolderStructureGenerator = new FolderStructureGenerator();
		FolderStructureGenerator.generate();
	}
}
