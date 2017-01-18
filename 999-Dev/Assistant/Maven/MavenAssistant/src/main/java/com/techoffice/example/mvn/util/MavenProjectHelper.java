package com.techoffice.example.mvn.util;

import java.io.File;

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
}
