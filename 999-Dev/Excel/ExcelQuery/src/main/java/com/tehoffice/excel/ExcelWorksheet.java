package com.tehoffice.excel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.tehoffice.excel.helper.ExcelWorksheetHelper;

public class ExcelWorksheet {
	
	private HSSFSheet sheet;
	
	public ExcelWorksheet(HSSFSheet sheet){
		this.sheet = sheet;
	}
	
	public HSSFSheet getSheet(){
		return sheet;
	}
	
	public List<Row> filter(int cellSeq, String value){
		List<Row> result = new ArrayList<Row>();
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			int lastCellNum = row.getLastCellNum();
			for (int i=0; i <lastCellNum; i++){
				Cell cell = row.getCell(i);
				String cellValue = ExcelWorksheetHelper.getCellValue(cell);
				if (cellValue.equals(value)){
					result.add(row);
				}
			}
		}
		return result;
	}
		
	public String toHtml(){
		String html = "<table>";
		int tableColNum = getMaxColNum();
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			html += "<tr>" + ExcelWorksheetHelper.rowToHtml(row, tableColNum) + "</tr>";
		}
		html += "</table>";
		return html;
	}
	
	public int getMaxColNum(){
		int maxColNum = 0;
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (row.getLastCellNum() > maxColNum){
				maxColNum = row.getLastCellNum();
			}
		}
		return maxColNum;
	}
	
	
	
	
}
