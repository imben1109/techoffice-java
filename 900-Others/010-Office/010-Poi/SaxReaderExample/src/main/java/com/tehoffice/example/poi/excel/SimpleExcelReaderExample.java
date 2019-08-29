package com.tehoffice.example.poi.excel;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.ooxml.util.SAXHelper;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;


public class SimpleExcelReaderExample {
	
	public static void main(String[] args) throws Exception{
		OPCPackage pkg = OPCPackage.open("SimpleExcelWriterExample.xlsx");
		XSSFReader r = new XSSFReader( pkg );
		SharedStringsTable sst = r.getSharedStringsTable();
		XMLReader xmlReader = SAXHelper.newXMLReader();
		ContentHandler handler = new SheetHandler(sst);
		xmlReader.setContentHandler(handler);
		InputStream sheet2 = r.getSheetsData().next();
		InputSource sheetSource = new InputSource(sheet2);
		xmlReader.parse(sheetSource);
		sheet2.close();
	}

}
