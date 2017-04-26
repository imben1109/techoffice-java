package com.techoffice.sdlc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;

/**
 * Test Plan Converter 
 * 
 * @author Ben_c
 *
 */
public class TestPlanConvertor {
	
	/**
	 * Main Program of Test Plan Convertor 
	 * 
	 * @param args The first parameter is Test Plan File and the second parameter is the Output File.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		
		if (args.length < 2){
			return;
		}
		
		String testPlanFile = args[0];
		String outputFile = args[1];
		
		int counter = 0;
		
		XWPFDocument outputDocx = new XWPFDocument();
		FileInputStream file = new FileInputStream(new File(testPlanFile));
		XWPFDocument docx = new XWPFDocument(file);
		XWPFTable table = docx.getTables().get(0);
		
		List<XWPFTableRow> rows = table.getRows();
		System.out.println("Number of Rows: " + rows.size());
		for (XWPFTableRow row: rows){
			
			List<XWPFTableCell> cells = row.getTableCells();
			String id = cells.get(0).getParagraphs().get(0).getText();
			String name = cells.get(1).getParagraphs().get(0).getText();
			CTVMerge merge = cells.get(1).getCTTc().getTcPr().getVMerge();
			if (merge != null){
				System.out.println(merge.getVal());
			}
			
			System.out.println(id + " " + name);
			
			XWPFParagraph titleParagraph = outputDocx.createParagraph();
			counter++;
			XWPFRun titleParagraphRun = titleParagraph.createRun();
			titleParagraphRun.setText(id + " " + name);
			
			List<XWPFParagraph> stepParagraphs = cells.get(3).getParagraphs();
			for (XWPFParagraph paragraph: stepParagraphs){
				outputDocx.createParagraph();
				outputDocx.setParagraph(paragraph, counter);
				counter++;
			}
			
			outputDocx.createParagraph().createRun();
			counter++;

			List<XWPFParagraph> resultParagraphs = cells.get(4).getParagraphs();
			for (XWPFParagraph paragraph: resultParagraphs){
				outputDocx.createParagraph();
				outputDocx.setParagraph(paragraph, counter);
				counter++;
			}
			
			outputDocx.createParagraph().createRun();
			counter++;
		}
		
		
		XWPFParagraph bodyParagraph = outputDocx.createParagraph();
		
		XWPFRun r = bodyParagraph.createRun();
        r.setText("Testing");
        FileOutputStream out = new FileOutputStream(outputFile);
        outputDocx.write(out);
        out.close();
	}
	
}
