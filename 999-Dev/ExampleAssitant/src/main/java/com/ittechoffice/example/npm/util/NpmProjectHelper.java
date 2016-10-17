package com.ittechoffice.example.npm.util;

import java.io.File;

public class NpmProjectHelper {
	
	public static boolean isNpmProject(File folder){
		File[] files = folder.listFiles();
		for (int i=0; i<files.length; i ++){
			File file = files[i];
			if (file.getName().equals("package.json")){
				return true;
			}
		}
		return false;
	}	
}
