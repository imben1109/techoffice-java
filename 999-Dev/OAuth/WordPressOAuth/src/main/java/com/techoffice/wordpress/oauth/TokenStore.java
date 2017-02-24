package com.techoffice.wordpress.oauth;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.techoffice.wordpress.config.ApplConfig;

public class TokenStore {
	public static final String folder = ".stores";
	public static final String storeFileName = ".WordPressOAuthStore";
	
	public static String readStoreFile(){
		String code = "";
		File storeFolder = new File(ApplConfig.configFolderPath, folder);
		File storeFile = new File(ApplConfig.configFolderPath + "/" + folder, storeFileName);
		
		if (!storeFolder.exists()){
			storeFolder.mkdirs();
		}
		
		if (storeFile.exists()){
			try {
				code = FileUtils.readFileToString(storeFile, StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		
		return code;
	}
	
	public static void writeStoreFile(String code) throws IOException{
		File storeFolder = new File(ApplConfig.configFolderPath, folder);
		File storeFile = new File(ApplConfig.configFolderPath  + "/" + folder, storeFileName);
		if (!storeFolder.exists()){
			storeFolder.mkdirs();
		}
		FileUtils.writeStringToFile(storeFile, code, StandardCharsets.UTF_8);
	}
	
	public static void delete(){
		File storeFile = new File(ApplConfig.configFolderPath  + "/" + folder, storeFileName);
		if (storeFile.exists()){
			storeFile.delete();
		}
	}
	
	public static void main(String[] args) throws IOException{
		TokenStore.writeStoreFile("abc");
		String code = TokenStore.readStoreFile();
		System.out.println(code);
		TokenStore.delete();
	}
}
