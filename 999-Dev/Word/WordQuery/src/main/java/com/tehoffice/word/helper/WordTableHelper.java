package com.tehoffice.word.helper;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;

public class WordTableHelper {
	
	public static String cellListToHtml(List<XWPFTableCell> cells){
		String html = "";
		for (XWPFTableCell cell: cells){
			html += "<td>" + cell.getText() + "</td>";
		}
		return html;
	}
	
}
