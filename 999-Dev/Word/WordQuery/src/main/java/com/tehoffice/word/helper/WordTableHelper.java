package com.tehoffice.word.helper;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;

public class WordTableHelper {
	
	public static String cellListToHtml(List<XWPFTableCell> cells, int tableColNum){
		String html = "";
		for (XWPFTableCell cell: cells){
			html += "<td>" + cell.getText() + "</td>";
		}
		int appendEmptyColNum = tableColNum - cells.size();
		for (int i=0 ; i<appendEmptyColNum ; i++){
			html += "<td></td>";

		}
		return html;
	}
	
	public static String cellListToText(List<XWPFTableCell> cells, String cellSeparator){
		String text = "";
		for (XWPFTableCell cell: cells){
			text += cell.getText() + cellSeparator;
		}
		return text;
	}
	
}
