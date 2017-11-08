package com.techoffice.oracle.pojo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.techoffice.oracle.dao.TableDao;
import com.techoffice.oracle.model.Column;
import com.techoffice.oracle.pojo.generator.PojoGenerator;
import com.techoffice.oracle.util.PojoUtil;

@Service
public class PojoService {
	
	@Autowired
	private TableDao tableDao;
	
	public JDefinedClass generateJavaCode(String packageName, String tableName) throws JClassAlreadyExistsException, IOException{
		List<Column> columns = tableDao.getTableColumnList(tableName);
		String modelClassName = PojoUtil.getClassName(tableName);
		PojoGenerator pojoGenerator = new PojoGenerator(packageName, modelClassName);
		for (Column column: columns){
			String modelFieldName = PojoUtil.getFieldName(column.getColumnName());
			pojoGenerator.addField(column, PojoUtil.getClassType(column), modelFieldName);
		}
		File output = new File("Java");
		if (!output.exists()){
			output.mkdir();
		}
		return pojoGenerator.generateCode(output);
	}
}
