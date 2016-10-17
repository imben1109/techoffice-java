package com.ittechoffice.example.bower.util;

import java.io.File;

public class BowerProjectHelper {
	
	public static boolean isBowerProject(File folder){
		File[] files = folder.listFiles();
		for (int i=0; i<files.length; i ++){
			File file = files[i];
			if (file.getName().equals("bower.json")){
				return true;
			}
		}
		return false;
	}	
}
