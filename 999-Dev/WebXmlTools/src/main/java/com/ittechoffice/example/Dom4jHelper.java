package com.ittechoffice.example;

import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

@Service
public class Dom4jHelper {
	
	public Document parse(String xml, boolean skipDtdValidation) throws DocumentException{
        SAXReader reader = new SAXReader(false);
        if (skipDtdValidation){
        	reader.setEntityResolver(new SkipDtdValidationResolver());
        }
        Document document = reader.read(new StringReader(xml));
        return document;
	}
	
	public Document parse(String xml) throws DocumentException{
		return parse(xml, true);
	}
	
}
