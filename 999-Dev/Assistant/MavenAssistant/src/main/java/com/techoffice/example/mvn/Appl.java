package com.techoffice.example.mvn;

import java.io.File;
import java.util.List;

import com.techoffice.example.mvn.model.Model;
import com.techoffice.example.mvn.service.MavenProjectService;
import com.techoffice.example.mvn.service.PomReader;

public class Appl {
	
	public static void main(String[] args) throws Exception{
		String home = ApplProperty.getExampleHome();
		MavenProjectService mavenProjectService = new MavenProjectService();
		List<File> mavenProjectList = mavenProjectService.getMavenProjectList(home);
		for (File mavenProject: mavenProjectList){
			String pomPath = new File(mavenProject.getPath(), "pom.xml").getPath();
			Model model = PomReader.getModel(pomPath);
			if (!mavenProject.getName().equals(model.getArtifactId())){
				model.setArtifactId(mavenProject.getName());
				PomReader.saveModel(model, pomPath);
				System.out.println("ArtifactId of " + pomPath + "updated");
			}
		}
	}
}
