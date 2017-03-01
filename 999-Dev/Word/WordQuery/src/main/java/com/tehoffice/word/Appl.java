package com.tehoffice.word;

import java.io.File;
import java.io.IOException;

public class Appl {
	
	public static void main(String[] args) throws IOException{
		WordDocument document = new WordDocument(new File("SimpleWordWriterExample.docx"));
		System.out.println(document.getTable(0).toHtml());
	}
	
}
