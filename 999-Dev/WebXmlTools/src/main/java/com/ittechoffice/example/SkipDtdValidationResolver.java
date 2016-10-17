package com.ittechoffice.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SkipDtdValidationResolver implements EntityResolver{

	@Override
	public InputSource resolveEntity(String arg0, String arg1) throws SAXException, IOException {
		// TODO Auto-generated method stub
        return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
	}

}
