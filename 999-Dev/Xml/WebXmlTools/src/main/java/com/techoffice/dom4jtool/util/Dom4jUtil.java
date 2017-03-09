package com.techoffice.dom4jtool.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Dom4jUtil {
	
	public static Document parse(String xml, boolean skipDtdValidation) throws DocumentException{
        SAXReader reader = new SAXReader(false);
        if (skipDtdValidation){
        	reader.setEntityResolver(new EntityResolver(){
				@Override
				public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
			        return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
				}
        	});
        }
        Document document = reader.read(new StringReader(xml));
        return document;
	}
	
	public static Document parse(String xml) throws DocumentException{
		return parse(xml, true);
	}
	
	
}
