package com.techoffice.reader.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;

import com.techoffice.util.exception.BaseExcelReaderException;

public abstract class BaseExcelReader<T> {

	public abstract InputStream getConfig();
		
	public abstract T getBean();
	
	public T read(File file){
		try{
			T bean = getBean();
			InputStream config = getConfig();
			XLSReader mainReader = ReaderBuilder.buildFromXML(config);
		    Map<String, Object> map = new HashMap<String, Object>();
		    map.put("bean", bean);
		    mainReader.read(new FileInputStream(file), map);
			return bean;
		} catch(Exception e){
			throw new BaseExcelReaderException(e);
		}
	}
}
