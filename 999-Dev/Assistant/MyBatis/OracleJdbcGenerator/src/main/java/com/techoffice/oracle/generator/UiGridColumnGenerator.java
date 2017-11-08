package com.techoffice.oracle.generator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.techoffice.oracle.model.Column;
import com.techoffice.oracle.util.PojoUtil;

public class UiGridColumnGenerator {
	public static String generate(String tableName, List<Column> columns){
		List<String> columnDefList = new ArrayList<String>();
		for (Column column: columns){
			StringWriter columnsContent = new StringWriter();
			PrintWriter printWriter = new PrintWriter(columnsContent);
			printWriter.println("{");
			printWriter.println("  name: " + "'" + PojoUtil.getFieldName(column.getColumnName()) + "',");
			printWriter.println("  field: " + "'" + PojoUtil.getFieldName(column.getColumnName()) + "'" );
			printWriter.println("}");
			printWriter.flush();
			printWriter.close();
			columnDefList.add(columnsContent.toString());
		}
		return StringUtils.join(columnDefList, ",");
	}
}
