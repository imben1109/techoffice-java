package com.ittechoffice.example;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class SimpleDom4jExample {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws DocumentException{
		String xml = "<?xml version='1.0'?><bookstore><div></div><div></div></bookstore>";
		SAXReader reader = new SAXReader();
		Document document = reader.read(new ByteArrayInputStream(xml.getBytes()));
		System.out.println(document.asXML());
	}
}
