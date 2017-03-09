package com.tehoffice.excel.helper;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelWorksheetHelper {
	
	public static String getCellValue(Cell cell){
		String cellValue = "";

		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
			cellValue = Boolean.toString(cell.getBooleanCellValue());
		}else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA){
			cellValue = cell.getCellFormula();
		}else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			cellValue = Double.toString(cell.getNumericCellValue());
		}else if (cell.getCellType() == Cell.CELL_TYPE_STRING){
			cellValue = cell.getStringCellValue();
		}
		
		return cellValue;
	}
	
	public static String rowToHtml(Row row, int tableColNum){
		String html = "";
		Iterator<Cell> cellIterator = row.cellIterator();
		while(cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			String cellValue = getCellValue(cell);
			html += "<td>" + cellValue + "</td>";
		}
		
		int missingColNum = tableColNum - row.getLastCellNum();
		for (int i = 0; i < missingColNum ; i++){
			html += "<td></td>";
		}
		return html;
	}
	
	public static int getRowListMaxColNum(List<Row> rowList){
		int maxColNum = 0;
		for(Row row: rowList){
			if (row.getLastCellNum() > maxColNum){
				maxColNum = row.getLastCellNum();
			}
		}
		return maxColNum;
	}
	
	public static String rowListToHtml(List<Row> rowList){
		String html = "<table>";
		int tableColNum = getRowListMaxColNum(rowList);
		for (Row row: rowList){
			html += "<tr>" + ExcelWorksheetHelper.rowToHtml(row, tableColNum) + "</tr>";

		}
		html += "</table>";
		return html;
	}
	
}
