package com.tehoffice.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelWorkbook {
	
	private File excelFile;
	private HSSFWorkbook workbook;
	
	public ExcelWorkbook(File excelFile) throws IOException{
		this.excelFile = excelFile;
		FileInputStream fileInputStream = new FileInputStream(excelFile);
		workbook = new HSSFWorkbook(fileInputStream);
		fileInputStream.close();
	}
	
	public HSSFWorkbook getWorkbook(){
		return workbook;
	}
	
	public File getExcelFile(){
		return excelFile;
	}
	
	public ExcelWorksheet getSheet(int seq){
		return new ExcelWorksheet(workbook.getSheetAt(seq));
	}
	
	
}
