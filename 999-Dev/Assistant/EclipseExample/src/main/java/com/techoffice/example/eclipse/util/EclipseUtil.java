package com.techoffice.example.eclipse.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.techoffice.example.eclipse.EclipseConstant;
import com.techoffice.example.eclipse.model.Project;


public class EclipseUtil {
	public static Project parseProject(File file) throws FileNotFoundException, JAXBException{
		InputStream stream = new FileInputStream(file);
		JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StreamSource streamSource = new StreamSource(stream);
		JAXBElement<Project> modelJaxbElement = jaxbUnmarshaller.unmarshal(streamSource, Project.class);
		Project project = modelJaxbElement.getValue();
		return project;
	}
	
	public static boolean isEclipseProject(String path){
		File file = new File(path, EclipseConstant.projectFile);
		if (file.exists()){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws URISyntaxException, FileNotFoundException, JAXBException{
		Path root = Paths.get(EclipseUtil.class.getClassLoader().getResource(".").toURI()).getParent().getParent();
		String rootPath = root.toString();
		File eclipseProjectFile = new File(rootPath, ".project");
		Project project = parseProject(eclipseProjectFile);
		System.out.println(project.getName());
	}
}
