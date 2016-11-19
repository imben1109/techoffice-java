package com.ittechoffice.example;

import java.io.File;
import java.io.StringWriter;

import org.docx4j.TextUtils;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

/**
 * This example show simple content extraction from Microsoft Word Document.
 * 
 * @author Ben
 *
 */
public class Appl {
	public static void main(String[] args) throws Exception{
		String sampleDocxPath = Appl.class.getClassLoader().getResource("Sample.docx").getPath();
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(sampleDocxPath));
		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
		
        StringWriter stringWriter = new StringWriter();
		TextUtils.extractText(documentPart.getContents(), stringWriter);
		stringWriter.close();
		String content = stringWriter.toString();
		System.out.println(content);
	}
}
