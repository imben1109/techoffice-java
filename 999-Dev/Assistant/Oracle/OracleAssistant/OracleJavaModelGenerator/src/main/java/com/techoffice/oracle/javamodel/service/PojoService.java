package com.techoffice.oracle.javamodel.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.CaseFormat;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.techoffice.oracle.javamodel.constant.ColumnConstant;
import com.techoffice.oracle.javamodel.dao.TableDao;
import com.techoffice.oracle.javamodel.generator.PojoGenerator;
import com.techoffice.oracle.javamodel.model.Column;

@Service
public class PojoService {
	
	@Autowired
	private TableDao tableDao;
	
	public void generate(String packageName, String tableName) throws JClassAlreadyExistsException, IOException{
		List<Column> columns = tableDao.getTableColumnList(tableName);
		String modelClassName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
		System.out.println(modelClassName);
		PojoGenerator pojoGenerator = new PojoGenerator(packageName, modelClassName);
		for (Column column: columns){
			String modelFieldName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column.getColumnName());
			if (ColumnConstant.VARCHAR2.equals(column.getDataType())){
				pojoGenerator.addField(String.class, modelFieldName);
			}else if (ColumnConstant.NUMBER.equals(column.getDataType())){
				pojoGenerator.addField(int.class, modelFieldName);
			}else if (ColumnConstant.DATE.equals(column.getDataType())){
				pojoGenerator.addField(Date.class, modelFieldName);
			}
		}
		File output = new File("Output");
		if (!output.exists()){
			output.mkdir();
		}
		pojoGenerator.generateCode(output);
	}
}
