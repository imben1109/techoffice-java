package com.techoffice.oracle.generator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.techoffice.oracle.constant.PackageConstant;
import com.techoffice.oracle.model.Column;

public class PackageSpecGenerator {
	
	public static String generatePackageSpec(String tableName, List<Column> columns ){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("CREATE OR REPLACE PACKAGE %s_%s AS ", PackageConstant.PACKAGE_PREFIX, tableName));
		printWriter.println(String.format(""));
		String insertProc = genInsertProc(tableName, columns);
		printWriter.println(String.format("%s", insertProc));
		String searchProc = genSearchProc(tableName, columns);
		printWriter.println(String.format("%s", searchProc));
		String updateProc = genUpdateProc(tableName, columns);
		printWriter.println(String.format("%s", updateProc));
		String deleteProc = genDeleteProc(tableName, columns);
		printWriter.println(String.format("%s", deleteProc));
		printWriter.println(String.format("END %s_%s;", PackageConstant.PACKAGE_PREFIX, tableName));
		printWriter.println(String.format(""));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public static String genInsertProc(String tableName, List<Column> columns ){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("  PROCEDURE %s_%s (", PackageConstant.INSERT_PREFIX, tableName));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			paramList.add(String.format("    P_IN_%-10s %-10s", column.getColumnName(), column.getDataType()));
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("  ) ; "));
		printWriter.println(String.format(""));

		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public static String genSearchProc(String tableName, List<Column> columns){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("  PROCEDURE %s_%s ( ", PackageConstant.SEARCH_PREFIX, tableName));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			paramList.add(String.format("    P_IN_%-15s  IN  %-10s", column.getColumnName(), column.getDataType()));
		}
		paramList.add(String.format("    P_IN_%-15s  IN  %-10s", "CURRENT_PAGE", "NUMBER"));
		paramList.add(String.format("    P_IN_%-15s  IN  %-10s", "PAGE_SIZE", "NUMBER"));
		paramList.add(String.format("    P_OUT_%-15s OUT %-10s", "RESULT_CUR", "SYS_REFCURSOR"));

		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("  ) ;"));
		
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public static String genUpdateProc(String tableName, List<Column> columns ){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("  PROCEDURE %s_%s ( ", PackageConstant.UPDATE_PREFIX, tableName));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			paramList.add(String.format("    P_IN_%-10s %-10s", column.getColumnName(), column.getDataType()));
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("  ) ;"));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public static String genDeleteProc(String tableName, List<Column> columns ){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("  PROCEDURE %s_%s ( ", PackageConstant.DELETE_PREFIX, tableName));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			if (column.isIndexColumn()){
				paramList.add(String.format("    P_IN_%-10s %-10s", column.getColumnName(), column.getDataType()));
			}
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("  ) ;"));
		printWriter.println(String.format("  "));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
}
