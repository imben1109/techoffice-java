package com.tehoffice.word;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.tehoffice.word.helper.TableRowListHelper;

public class Appl {
	
	public static void main(String[] args) throws IOException{
		WordDocument document = new WordDocument(new File("\\\\dvservk1\\EMS\\50-Testing\\90-Test Plan\\40-Regression Test\\Test Plan (PRD v2.1.0)\\EMS-Test Scenario and Cases_Batch Jobs (Schedule Jobs)_v.2.1.0.docx"));
		List<List<XWPFTableRow>> results = TableRowListHelper.splitRowList(document.getTable(0).list(), 0, "Function ID & Name:");
		results.remove(0);
		for (List<XWPFTableRow> result: results){
			result.remove(1);
			System.out.println(TableRowListHelper.toText(result, "\r\n", "\r\n\r\n"));
		}
	}
	
}
