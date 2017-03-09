package com.tehoffice.word.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class TableRowListHelper {
	
	public static int getMaxColNum(List<XWPFTableRow> rows){
		int maxColNum = 0;
		for (XWPFTableRow row: rows){
			if (row.getTableCells().size() > maxColNum){
				maxColNum = row.getTableCells().size() ;
			}
		}
		return maxColNum;
	}
	
	public static List<List<XWPFTableRow>> splitRowList(List<XWPFTableRow> rows, int colId, String value){
		List<List<XWPFTableRow>> results = new ArrayList<List<XWPFTableRow>>();
		List<XWPFTableRow> result = new ArrayList<XWPFTableRow>();
		for (XWPFTableRow row: rows){
			if (row.getCell(colId).getText().equals(value)){
				results.add(result);
				result = new ArrayList<XWPFTableRow>();
				result.add(row);
			}else{
				result.add(row);
			}
		}
		results.add(result);
		return results;
	}
	
	public static String toHtml(List<XWPFTableRow> rows){
		String html = "<table>";
		int tableColNum = TableRowListHelper.getMaxColNum(rows);
		for (XWPFTableRow row: rows){
			html += "<tr>" + WordTableHelper.cellListToHtml(row.getTableCells(), tableColNum) + "</tr>";
		}
		html += "</table>";
		return html;
	}
	
	public static String toText(List<XWPFTableRow> rows, String colSeparator, String rowSeparator){
		String text = "";
		for (XWPFTableRow row: rows){
			text += WordTableHelper.cellListToText(row.getTableCells(), colSeparator) + rowSeparator; 
		}
		return text;
	}

	
}
