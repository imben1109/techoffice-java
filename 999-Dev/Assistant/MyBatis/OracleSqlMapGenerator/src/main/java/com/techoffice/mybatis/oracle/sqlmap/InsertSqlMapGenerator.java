package com.techoffice.mybatis.oracle.sqlmap;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.CaseFormat;
import com.techoffice.mybatis.oracle.model.TableColumn;
import com.techoffice.mybatis.oracle.sqlmap.intf.SqlMapGenerator;
import com.techoffice.mybatis.oracle.sqlmap.intf.TableHelper;

public class InsertSqlMapGenerator implements SqlMapGenerator{

	public void generate() {
		String insertSql = "INSERT INTO {0} (\r\n{1}\r\n) VALUES (\r\n{2}\r\n);";
		String columnStr = "";
		String valueStr = "";
		String tableName = "help";
		List<TableColumn> tableColumnList = TableHelper.getTableColumnList(tableName);
		List<String> columnNames = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		for(TableColumn tableColumn: tableColumnList){
			columnNames.add("\t" + tableColumn.getColumnName());
			String javaVariable = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableColumn.getColumnName());
			String value = "\t#{" +javaVariable +", jdbcType=" + tableColumn.getDataType() + "}";
			valueList.add(value);
		}
		columnStr = StringUtils.join(columnNames, ",\r\n");
		valueStr = StringUtils.join(valueList, ",\r\n");
		String sql = MessageFormat.format(insertSql, tableName, columnStr, valueStr);
		System.out.println(sql);
	}
	
	public static void main(String[] args){
		InsertSqlMapGenerator insertSqlMapGenerator = new InsertSqlMapGenerator();
		insertSqlMapGenerator.generate();
	}

}
