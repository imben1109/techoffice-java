package com.techoffice.example.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.techoffice.example.mvn.constant.MavenProjectContant;

public class FileUtil {
	private static final Logger logger = Logger.getLogger(FileUtil.class);
	
	public static void createFolderIfNotExist(File file){
		if (!file.exists()){
			file.mkdirs();
		}
	}
	public static void createFolderIfNotExistWithGitKeep(File file) throws IOException{
		File gitKepp = new File(file.getPath(), MavenProjectContant.GITKEEP);
		if (!file.exists()){
			file.mkdirs();
		}
		if (!gitKepp.exists()){
			logger.debug("Creating file on " + gitKepp.getPath());
			gitKepp.createNewFile();	
		}
	}
}
