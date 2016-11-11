package com.ittechoffice.example.mvn.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import com.ittechoffice.example.mvn.model.Pom;

/**
 * Each maven project has a pom.xml file. It contain the meta information of project 
 * 
 * @author Ben
 *
 */
public class PomFileReader {
	public static void read(File file) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(Pom.class);
		Unmarshaller  jaxbUnmarshaller  = jaxbContext.createUnmarshaller();
		jaxbUnmarshaller.setEventHandler(new ValidationEventHandler(){
			public boolean handleEvent(ValidationEvent event) {
				return true;
			}
		});
		Pom customer = (Pom) jaxbUnmarshaller.unmarshal(file);
	}
	
	public static void main(String[] args) throws JAXBException{
	}
}
