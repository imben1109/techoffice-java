package com.ittechoffice.example;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class Appl {
	
	public static void main(String[] args) throws URISyntaxException, Docx4JException, JAXBException{
		String home = Paths.get(Appl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		String templateFilename = "template.docx";
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new java.io.File(home + "/Template/" + templateFilename));
		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

		HashMap<String, String> mappings = new HashMap<String, String>();
		mappings.put("name", "Testing");
		documentPart.variableReplace(mappings);

		Docx4J.save(wordMLPackage, new File(home + "/Output/out.docx"));

	}
}
