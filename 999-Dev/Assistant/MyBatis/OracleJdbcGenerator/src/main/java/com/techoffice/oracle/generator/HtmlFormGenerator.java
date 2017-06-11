package com.techoffice.oracle.generator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import com.techoffice.oracle.model.Column;
import com.techoffice.oracle.util.PojoUtil;
import com.techoffice.oracle.util.StringUtil;

public class HtmlFormGenerator {
	
	public static String generate(String tableName, List<Column> columns){
		String formName = StringUtil.convertFirstCharToLowerCase(PojoUtil.getClassName(tableName)) + "Form";
		StringWriter formContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(formContent);
		for (Column column: columns){
			printWriter.println(String.format("<input ng-model=\"%s.%s\">", formName, PojoUtil.getFieldName(column.getColumnName())));
		}
		printWriter.flush();
		printWriter.close();
		return formContent.toString();
	}
}
