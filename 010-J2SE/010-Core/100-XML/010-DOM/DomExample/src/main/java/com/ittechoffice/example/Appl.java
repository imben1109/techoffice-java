package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Appl {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		File file = new File(Appl.class.getClassLoader().getResource("testing.xml").getFile());
		Document document = DocumentFactory.createDocument(file);
		Element element = document.getElementById("tag22");
		System.out.println(element.getTextContent());
	}
}
