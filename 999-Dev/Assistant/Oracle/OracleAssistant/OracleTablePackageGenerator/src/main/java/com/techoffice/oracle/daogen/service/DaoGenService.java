package com.techoffice.oracle.daogen.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.techoffice.oracle.daogen.generator.DaoGenGenerator;
import com.techoffice.oracle.util.PojoUtil;

@Service
public class DaoGenService {

	public JDefinedClass genDao(String packageName, String tableName) throws JClassAlreadyExistsException, IOException {
		DaoGenGenerator generator = new DaoGenGenerator(packageName, PojoUtil.getClassName(tableName) + "Dao");
		generator.addMethod("insert");
		generator.addMethod("search");
		generator.addMethod("update");
		generator.addMethod("delete");
		File output = new File("Java");
		if (!output.exists()){
			output.mkdir();
		}
		return generator.generateCode(output);
	}
}
