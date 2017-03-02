package com.tehoffice.word;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.tehoffice.word.helper.TableRowListHelper;
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
		return TableRowListHelper.toHtml(table.getRows());
	}
	
	public List<XWPFTableRow> filter(int colSeq, String value){
		List<XWPFTableRow> result = new ArrayList<XWPFTableRow>();
		for (XWPFTableRow row: table.getRows()){
			XWPFTableCell cell = row.getCell(colSeq);
			if (cell.getText().equals(value)){
				result.add(row);
			}
		}
		return result;
	}
	
	public List<XWPFTableRow> list(){
		return table.getRows();
	}
}
