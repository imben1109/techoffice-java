package com.techoffice.example.mvn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import com.techoffice.example.mvn.model.Model;
import com.techoffice.example.mvn.model.ObjectFactory;

public class PomUtil {
	
	public static Model getModel(String path) throws Exception{
		Model model = null;
		File pomFile = new File(path);
		InputStream stream = null;
		try{
			stream = new FileInputStream(pomFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(Model.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StreamSource streamSource = new StreamSource(stream);
			JAXBElement<Model> modelJaxbElement = jaxbUnmarshaller.unmarshal(streamSource, Model.class);
			model = modelJaxbElement.getValue();
		} catch (IOException e) {
			throw new Exception("Fails to open file: " + path);
		} catch (JAXBException e) {
			throw new Exception("Fails to parse file: " + path);
		} finally{
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return model;
	}
	
	public static void saveModel(Model model, String path) throws Exception{
		ObjectFactory objectFactory = new ObjectFactory (); 
		JAXBElement<Model> modelJaxbElement = objectFactory.createProject(model);
		JAXBContext jaxbContext = JAXBContext.newInstance(Model.class);		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");
		File file = new File(path);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		jaxbMarshaller.marshal(modelJaxbElement, fileOutputStream);

	}
	
	public static void main(String[] args) throws Exception {
		String root  = Paths.get(PomUtil.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		File pomFile = new File(root, "pom.xml");
		Model model = PomUtil.getModel(pomFile.getPath());
		System.out.println(model.getArtifactId());
		File genPomFile = new File(root, "genPom.xml");
		PomUtil.saveModel(model, genPomFile.getPath());
	}

}
