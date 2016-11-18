package com.ittechoffice.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Appl {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        TagNameSaxHandler handler = new TagNameSaxHandler();
        XMLReader xmlReader = XMLReaderFactory.createXmlReader(handler);
        InputStream inputStream = Appl.class.getClassLoader().getResourceAsStream("testing.xml");
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        InputSource is = new InputSource(reader);
        xmlReader.parse(is);
        List < String > list = handler.getTagNameList();
        for (String tagName: list) {
            System.out.println(tagName);
        }
	}
}
