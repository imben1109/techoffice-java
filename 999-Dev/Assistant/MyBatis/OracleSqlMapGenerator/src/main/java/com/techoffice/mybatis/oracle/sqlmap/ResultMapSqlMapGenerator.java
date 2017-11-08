package com.techoffice.mybatis.oracle.sqlmap;

import java.text.MessageFormat;
import java.util.List;

import com.techoffice.mybatis.oracle.dao.TableColumnDao;
import com.techoffice.mybatis.oracle.model.TableColumn;
import com.techoffice.mybatis.oracle.sqlmap.intf.SqlMapGenerator;
import com.techoffice.mybatis.oracle.util.JavaVariableHelper;

public class ResultMapSqlMapGenerator implements SqlMapGenerator{
	
	public static final String TEMPLATE = "<result property=\"{0}\" column=\"{1}\"/>";

	public void generate(String tableName) {
		List<TableColumn> tableColumnList = TableColumnDao.getTableColumnList(tableName);
		for (TableColumn tableColumn: tableColumnList){
			String mapping = MessageFormat.format(TEMPLATE, 
					JavaVariableHelper.covert(tableColumn.getColumnName()), 
					tableColumn.getColumnName());
			System.out.println(mapping);
		}
	}
	
	public static void main(String[] args){
		ResultMapSqlMapGenerator resultMapSqlMapGenerator = new ResultMapSqlMapGenerator();
		resultMapSqlMapGenerator.generate("help");
	}
}
