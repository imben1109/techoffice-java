package com.tehoffice.word;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.tehoffice.word.helper.WordTableHelper;

public class WordTable {
	
	private XWPFTable table;
	
	public WordTable(XWPFTable table){
		this.table = table;
	}
	
	public XWPFTable getTable(){
		return table;
	}
	
	public String toHtml(){
		String html = "<table>";
		List<XWPFTableRow> rows = table.getRows();
		for (XWPFTableRow row: rows){
			html += "<tr>" + WordTableHelper.cellListToHtml(row.getTableCells()) + "</tr>";
		}
		html += "</table>";
		return html;
	}
}
