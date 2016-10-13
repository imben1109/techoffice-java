package com.ittehoffice.example.poi.word;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class SimpleWordWriterExample {
	
	private String content;
	
	public SimpleWordWriterExample(String content){
		this.content = content;
	}
	
	public void write(String dest) throws IOException{
		XWPFDocument docx = new XWPFDocument();
		XWPFParagraph bodyParagraph = docx.createParagraph();
		XWPFRun r = bodyParagraph.createRun();
        r.setText(content);
        FileOutputStream out = new FileOutputStream(dest);
        docx.write(out);
        out.close();
	}
	
	public static void main(String[] args) throws IOException{
		SimpleWordWriterExample simpleWordWriterExample = new SimpleWordWriterExample("Testing Contents");
		simpleWordWriterExample.write("SimpleWordWriterExample.docx");
	}
}
