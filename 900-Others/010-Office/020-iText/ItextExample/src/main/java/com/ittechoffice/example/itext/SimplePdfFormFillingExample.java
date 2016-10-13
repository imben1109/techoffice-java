package com.ittechoffice.example.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * SimplePdfFormFillingExample is an example of filling fields of existing pdf
 * 
 * @author Ben_c
 *
 */
public class SimplePdfFormFillingExample {
	
	/**
	 * The File path of existing pdf file
	 */
	private String filePath;
	
	/**
	 * Constructor
	 * 
	 * @param filePath
	 */
	public SimplePdfFormFillingExample(String filePath){
		this.filePath = filePath;
	}
	
	/**
	 * Reading the existing pdf file and fill the fields, Name and Company
	 * 
	 * @param dest The file path of output PDF file
	 * @throws IOException
	 * @throws DocumentException
	 */
	public void fill(String dest) throws IOException, DocumentException{
        PdfReader reader = new PdfReader(filePath);
		
        // List the Fields
        AcroFields fields = reader.getAcroFields();
        Set<String> fieldsKeySet = fields.getFields().keySet();
        for (String key: fieldsKeySet){
        	System.out.println(key);
        }
        
        // Fill the Fields
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        AcroFields form = stamper.getAcroFields();
        form.setField("Name", "1.0", "100%");
        form.setField("Company", "1217000.000000", "$1,217,000");
        stamper.close();
	}
	
	/**
	 * Main Program for SimplePdfFormFillingExample
	 * @param args
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void main(String[] args) throws IOException, DocumentException{
		String inputFilePath = SimplePdfFormFillingExample.class.getClassLoader().getResource("SimplePdfFormFillingExample.pdf").getPath();
		SimplePdfFormFillingExample simplePdfFormFillingExample = new SimplePdfFormFillingExample(inputFilePath);
		simplePdfFormFillingExample.fill("output/SimplePdfFormFillingExample.pdf");
	}
}
