package com.ittechoffice.example.batch;

import java.io.File;
import java.io.StringWriter;

import org.docx4j.TextUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class DocxExtractor {
	public static String extract(File file) throws Exception{
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(file);
		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        StringWriter stringWriter = new StringWriter();
		TextUtils.extractText(documentPart.getContents(), stringWriter);
		stringWriter.close();
		String content = stringWriter.toString();
		return content;
	}
}
