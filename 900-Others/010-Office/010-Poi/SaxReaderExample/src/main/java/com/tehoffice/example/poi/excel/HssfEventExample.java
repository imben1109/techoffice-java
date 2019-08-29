package com.tehoffice.example.poi.excel;

import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.InputStream;

public class HssfEventExample {
    public static void main(String[] args) throws Exception{


        FileInputStream fin = new FileInputStream("SimpleExcelReaderExample.xls");
        POIFSFileSystem poifs = new POIFSFileSystem(fin);
        InputStream din = poifs.createDocumentInputStream("Workbook");
        HSSFRequest req = new HSSFRequest();
        req.addListenerForAllRecords(new HssfEventHandler());
        HSSFEventFactory factory = new HSSFEventFactory();
        factory.processEvents(req, din);
        fin.close();
        din.close();
    }
}
