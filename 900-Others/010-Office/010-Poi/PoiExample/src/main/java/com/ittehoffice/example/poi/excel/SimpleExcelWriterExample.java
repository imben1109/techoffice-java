package com.ittehoffice.example.poi.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SimpleExcelWriterExample {
	
	private String content;
	
	public SimpleExcelWriterExample(String content){
		this.content = content;
	}
	
	public void write(String dest) throws IOException{
	      XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("Simple Excel Writer");
	      XSSFRow row = spreadsheet.createRow(0);
	      Cell cell = row.createCell(0);
	      cell.setCellValue(content);
	      FileOutputStream out = new FileOutputStream(new File(dest));
	      workbook.write(out);
	      out.close();
	}
	
	public static void main(String[] args) throws IOException{
		SimpleExcelWriterExample SimpleExcelWriterExample = new SimpleExcelWriterExample("Testing Contents");
		SimpleExcelWriterExample.write("SimpleExcelWriterExample.xlsx");
	}
}
