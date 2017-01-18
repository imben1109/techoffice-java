package com.techoffice.javaproject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaProjectManager {
	
	private String srcPath;
	private List<File> javaFileList;
	
	public JavaProjectManager(String srcPath){
		this.srcPath = srcPath;
		javaFileList = new ArrayList<File>();
	}
	
	public int getNumJavaFile(){
		if (javaFileList.size() == 0 ){
			searchJavaFile(srcPath);
		}
		return javaFileList.size();
	}
	
	public List<File> getJavaFileList(){
		if (javaFileList.size() == 0 ){
			searchJavaFile(srcPath);
		}
		return javaFileList;
	}
	
	
	private void searchJavaFile(String path){
		File root = new File(path);
		File[] files = root.listFiles();
		for (int i=0; i<files.length; i++){
			File file = files[i];
			if (file.isFile() && file.getName().endsWith(".java")){
				javaFileList.add(file);
			}else if(file.isDirectory()){
				searchJavaFile(file.getPath());
			}
		}
	}
	

	public static void main(String[] args){
	}
}
