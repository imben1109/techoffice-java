package com.techoffice.reader.base;

import java.io.File;
import java.io.InputStream;

public abstract class BaseExcelReader<T> {

	public abstract InputStream getConfig();
	
	public abstract File getExcelFile();
	
	public abstract T getBean();
	
	public T read(){
		T bean = getBean();
		return bean;
	}
}
