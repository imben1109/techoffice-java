package com.ittechoffice.example.mvn.util;

import java.io.File;

import com.ittechoffice.example.mvn.constant.MavenProjectContant;

public class MavenProjectHelper {
	
	public static boolean isMavenProject(File folder){
		File[] files = folder.listFiles();
		for (int i=0; i<files.length; i ++){
			File file = files[i];
			if (file.getName().equals("pom.xml")){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMissingMainResourcesGiteep(File file){
		File mainResources = new File(file.getPath() + MavenProjectContant.MAIN_RESOURCES_GITKEEP);	
		if (!mainResources.exists()){
			return true;
		}
		return false;
	}
	
	public static boolean isMissingTestResourcesGitKeep(File file){
		File testResources = new File(file.getPath() + MavenProjectContant.TEST_JAVA_GITKEEP);
		if (!testResources.exists()){
			return true;
		}
		return false;
	}
	
	public static boolean isMissingTestJavaGitKeep(File file){
		File testJava = new File(file.getPath() + MavenProjectContant.TEST_RESOURCES_GITKEEP);
		if (!testJava.exists()){
			return true;
		}
		return false;
	}
	
	public static boolean isTargetClassExist(File file){
		File targetClass = new File(file.getPath() + MavenProjectContant.TARGET_CLASSES);
		if (targetClass.exists()){
			return true;
		}
		return false;
	}
	
	public static boolean isMissingGitKeep(File file){
		if (isMissingMainResourcesGiteep(file)){
			return true;
		}
		if (isMissingTestResourcesGitKeep(file)){
			return true;
		}
		if (isMissingTestJavaGitKeep(file)){
			return true;
		}
		return false;
	}
}
