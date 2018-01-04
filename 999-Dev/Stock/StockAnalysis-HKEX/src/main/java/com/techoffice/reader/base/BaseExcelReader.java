package com.techoffice.reader.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techoffice.util.exception.BaseExcelReaderException;

public abstract class BaseExcelReader<T> {

	public abstract InputStream getConfigInputStream();
		
	public abstract T getBean();
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public T read(File file){
		InputStream configInputStream = null;
		FileInputStream fileInputStream = null;
		try{
			T bean = getBean();
			configInputStream = getConfigInputStream();
			fileInputStream = new FileInputStream(file);
			XLSReader mainReader = ReaderBuilder.buildFromXML(configInputStream);
		    Map<String, Object> map = new HashMap<String, Object>();
		    map.put("bean", bean);
		    mainReader.read(fileInputStream, map);
		    return bean;
		} catch(Exception e){
			throw new BaseExcelReaderException(e);
		} finally {
			try {
				if (configInputStream != null){
					configInputStream.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
			
			try {
				if (fileInputStream != null){
					fileInputStream.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
}
