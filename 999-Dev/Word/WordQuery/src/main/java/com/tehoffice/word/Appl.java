package com.tehoffice.word;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.tehoffice.word.helper.TableRowListHelper;

public class Appl {
	
	public static void main(String[] args) throws IOException{
		WordDocument document = new WordDocument(new File("SimpleWordWriterExample.docx"));
		List<List<XWPFTableRow>> results = TableRowListHelper.splitRowList(document.getTable(0).list(), 0, "Function ID & Name:");
		results.remove(0);
		for (List<XWPFTableRow> result: results){
			result.remove(1);
			System.out.println(TableRowListHelper.toText(result, "\n", "\n\n\n"));
		}
	}
	
}
