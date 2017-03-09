package com.tehoffice.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.tehoffice.excel.helper.ExcelWorksheetHelper;

public class Appl {
	
	public static void main(String[] args) throws IOException{
		ExcelWorkbook workbook = new ExcelWorkbook(new File("SimpleExcelReaderExample.xls"));
		String html = workbook.getSheet(0).toHtml();
		System.out.println(html);
		System.out.println(workbook.getSheet(0).getMaxColNum());
		System.out.println(ExcelWorksheetHelper.rowListToHtml(workbook.getSheet(0).filter(0, "TEST11")));
	}
}
