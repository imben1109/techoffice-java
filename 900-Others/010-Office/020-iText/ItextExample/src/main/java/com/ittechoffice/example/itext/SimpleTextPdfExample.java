package com.ittechoffice.example.itext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * SimpleTextPdfExample is an example of creating simple PDF file.
 * The output PDF file would simply have title and content.
 * 
 * @author Ben_c
 *
 */
public class SimpleTextPdfExample {
	
	/**
	 * Title of the pdf file
	 */
	private String title;
	
	/**
	 * Content of the pdf file 
	 */
	private String content;
	
	/**
	 * Font of title
	 */
	private static final Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
	
	/**
	 * Font of content
	 */
	private static final Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
	
	/**
	 * Constructor
	 * @param title
	 * @param content
	 */
	public SimpleTextPdfExample(String title, String content){
		this.title = title;
		this.content = content;
	}
	
	/**
	 * Produce the PDF with the given destination path
	 * 
	 * @param dest The Destination Path
	 * 
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void createPdf(String dest) throws FileNotFoundException, DocumentException{
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();
        Chunk chunk = new Chunk(title, titleFont);
        Chapter chapter = new Chapter(new Paragraph(chunk), 1);
        chapter.setNumberDepth(0);
        chapter.add(new Paragraph(content, contentFont));
        document.add(chapter);
		document.close();
	}

	/**
	 * Main Program for SimpleTextPdfExample
	 * @param args
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public static void main(String[] args) throws FileNotFoundException, DocumentException{
		SimpleTextPdfExample pdf = new SimpleTextPdfExample("Testing Title", "Testing Content");
		pdf.createPdf("output/SimpleTextPdf.pdf");
	}
}
