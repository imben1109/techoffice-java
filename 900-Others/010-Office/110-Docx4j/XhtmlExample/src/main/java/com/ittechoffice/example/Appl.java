package com.ittechoffice.example;

import java.io.File;

import org.docx4j.Docx4J;
import org.docx4j.convert.out.HTMLSettings;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class Appl {
	
	//
	public static void main(String[] args) throws Docx4JException{
		
		String sampleDocxPath = Appl.class.getClassLoader().getResource("Sample.docx").getPath();
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(sampleDocxPath));
		
    	HTMLSettings htmlSettings = Docx4J.createHTMLSettings();
    	htmlSettings.setWmlPackage(wordMLPackage);
    	
		Docx4J.toHTML(htmlSettings, System.out, Docx4J.FLAG_EXPORT_PREFER_XSL);
	}
}
