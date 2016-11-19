package com.techoffice.example.mvn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.example.ExampleProperty;
import com.techoffice.example.mvn.pom.model.Model;
import com.techoffice.example.mvn.service.MavenProjectService;
import com.techoffice.example.mvn.util.PomUtil;

@Component
public class MavenProjectManager {
	
	private String path;
	private List<File> mavenProjectList;
	private List<File> invalidMavenProjectList;
	private List<File> dummyFileList;
	
	@Autowired
	private MavenProjectService mavenProjectService;
	
	public MavenProjectManager(){
		path = ExampleProperty.properties.getProperty(ExampleProperty.EXAMPLE_HOME);
		this.mavenProjectList = new ArrayList<File>();
		this.invalidMavenProjectList = new ArrayList<File>();
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
		updateInvalidMavenProjectList();
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
	
	public MavenProjectService getService(){
		return mavenProjectService;
	}
	
	public List<Model> getProjectModelList() throws Exception{
		List<Model> modelList = new ArrayList<Model>();
		for (File mavenProject: mavenProjectList){
			File pom = new File(mavenProject.getPath(), "pom.xml");
			Model model = PomUtil.getModel(pom.getPath());
			modelList.add(model);
		}
		return modelList;
	}
	
}
