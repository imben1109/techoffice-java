package com.ittechoffice.example.mvn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ittechoffice.example.mvn.service.MavenProjectService;

public class MavenProjectManager {
	
	private String path;
	private List<File> mavenProjectList;
	private List<File> invalidMavenProjectList;
	private List<File> dummyFileList;
	private MavenProjectService mavenProjectService;
	
	public MavenProjectManager(String path){
		this.mavenProjectService = new MavenProjectService();
		
		this.path = path;
		this.mavenProjectList = new ArrayList<File>();
		this.invalidMavenProjectList = new ArrayList<File>();
		
		this.updateMavenProjectList();
	}
	
	public int getNumInvalidMvnProj(){
		return invalidMavenProjectList.size();
	}
	
	public int getNumMvnProj(){
		return mavenProjectList.size();
	}
	
	public List<File> getMavenProjectList(){
		return this.mavenProjectList;
	}
	
	public List<File> getInvalidMavenProjectList(){
		return this.invalidMavenProjectList;
	}
	
	public List<File> updateMavenProjectList(){
		mavenProjectList = this.mavenProjectService.getMavenProjectList(path);
		return mavenProjectList;
	}
	
	public List<File> updateInvalidMavenProjectList(){
		invalidMavenProjectList = this.mavenProjectService.getInvalidMavenProjectList(mavenProjectList);
		return invalidMavenProjectList;
	}
	
	public void correctInvalidMavenProject() throws IOException{
		this.mavenProjectService.correctInvalidMavenProject(invalidMavenProjectList);
		this.mavenProjectService.getMavenProjectList(path);
		this.mavenProjectService.getInvalidMavenProjectList(mavenProjectList);
	}
	
	public List<File> getDummyFileList(){
		dummyFileList = this.mavenProjectService.getDummyFileList(this.mavenProjectList);
		return dummyFileList;
	}
	
	
	
}
