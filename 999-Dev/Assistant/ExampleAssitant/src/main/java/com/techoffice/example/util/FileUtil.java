package com.techoffice.example.util;

import java.io.File;
import java.io.IOException;

import com.techoffice.example.mvn.constant.MavenProjectContant;

public class FileUtil {
	public static void createFolderIfNotExist(File file){
		if (!file.exists()){
			file.mkdirs();
		}
	}
	public static void createFolderIfNotExistWithGitKeep(File file) throws IOException{
		File gitKepp = new File(file.getPath() + MavenProjectContant.MAIN_RESOURCES_GITKEEP);
		if (!file.exists()){
			file.mkdirs();
			gitKepp.createNewFile();
		}
	}
}
