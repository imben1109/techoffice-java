package com.techoffice.oracle.generator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import com.techoffice.oracle.model.Column;
import com.techoffice.oracle.util.PojoUtil;

public class PojoGenerator {
	public static String generate(List<Column> columns){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		for(Column column: columns){
			printWriter.println(String.format("private %s %s;", 
					PojoUtil.getJavaType(column),
					PojoUtil.getFieldName(column.getColumnName())));
		}
		printWriter.flush();
		printWriter.close();
		return procContent.toString();	
	}
}
