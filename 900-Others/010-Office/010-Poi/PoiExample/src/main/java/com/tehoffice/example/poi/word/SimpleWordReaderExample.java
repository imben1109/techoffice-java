package com.tehoffice.example.poi.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class SimpleWordReaderExample {
	
	public static void main(String[] args) throws IOException{
		FileInputStream file = new FileInputStream(new File("SimpleWordWriterExample.docx"));
		XWPFDocument docx = new XWPFDocument(file);
		String text = docx.getParagraphs().get(0).getText();
		System.out.println(text);
	}
}
