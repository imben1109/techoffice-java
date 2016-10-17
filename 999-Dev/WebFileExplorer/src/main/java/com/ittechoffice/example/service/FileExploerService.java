package com.ittechoffice.example.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ittechoffice.example.example.FeNotFolderException;
import com.ittechoffice.example.model.FeFile;

@Service
public class FileExploerService {
	
	public List<FeFile> list(String parent) throws FeNotFolderException{
		List<FeFile> feFileList = new ArrayList<FeFile>();
		File folder = new File(parent);
		if (!folder.isDirectory()){
			throw new FeNotFolderException();
		}
		
		File[] files = folder.listFiles();
		for (int i=0; i<files.length; i++){
			File file = files[i];
			FeFile feFile = new FeFile();
			feFile.setParent(parent);
			feFile.setName(file.getName());
			if (file.isFile()){
				feFile.setType(FeFile.FeFileType.FILE);
			}else if (file.isDirectory()){
				feFile.setType(FeFile.FeFileType.FOLDER);
			}
			feFileList.add(feFile);
		}
		return feFileList;
	}
	
}
