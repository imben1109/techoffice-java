package com.techoffice.generator.project.config;

import java.util.Properties;

import com.techoffice.database.dao.config.BaseConfig;

public class ProjectConfig {

	public static Properties prop = null;
	
	private static final String PROJECT_PATH = "project.path";
	private static final String PROJECT_NAME = "project.name";
	private static final String PROJECT_GROUP_ID = "project.group.id";
	private static final String PROJECT_ARTIFACT_ID = "project.artifact.id";
	
	static {
		prop = BaseConfig.getProperties();
	}
	
	public static Properties getProperties(){
		return prop;
	}
	
	public static String getProjectPath(){
		return prop.getProperty(PROJECT_PATH, "");
	}
	
	public static String getProjectName(){
		return prop.getProperty(PROJECT_NAME, "");
	}
	
	public static String getProjectGroupId(){
		return prop.getProperty(PROJECT_GROUP_ID, "");
	}
	
	public static String getProjectArtifactId(){
		return prop.getProperty(PROJECT_ARTIFACT_ID, "");
	}
	
}
