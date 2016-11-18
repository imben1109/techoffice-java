package com.ittechoffice.example.content;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Br;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;

/**
 * This example is similar to ContentClassExample. 
 * 
 * ContentParser parse the Content to readable String.
 * 
 * i.e. 
 * EMPTY_PARAGRAPH 
 * TEXT_PARAGRAPH
 * PAGE_BREAK
 * TABLE
 *  
 */
import com.ittechoffice.example.Appl;

public class ContentParser {
	
	public static final String EMPTY_PARAGRAPH = "EMPTY_PARAGRAPH";
	public static final String TEXT_PARAGRAPH = "TEXT_PARAGRAPH";
	public static final String PAGE_BREAK = "PAGE_BREAK";
	public static final String TABLE = "TABLE";
	
	public static String parse(Object obj){
		if (obj instanceof P){
			P p = (P) obj;
			return parseP(p);
		}else if (obj instanceof JAXBElement){
			JAXBElement<?> element = (JAXBElement<?>) obj;
			return parseJaxbElement(element);
		}
		return "";
	}
	
	public static String parseJaxbElement(JAXBElement<?> element){
		Object obj = element.getValue();
		if (obj instanceof Tbl){
			return "TABLE";
		}
		return "";
	}
	
	public static String parseP(P p){
		List<Object> list = p.getContent();
		if (list.size() == 0 ){
			return EMPTY_PARAGRAPH;
		}else if (list.size() == 1){
			if (list.get(0) instanceof R){
				R r = (R) list.get(0);
				if (r.getContent().size() == 1){
					if (r.getContent().get(0) instanceof JAXBElement){
						Object obj = ((JAXBElement<?>) r.getContent().get(0)).getValue();
						if (obj instanceof Text){
							return TEXT_PARAGRAPH;
						}
					}else if (r.getContent().get(0) instanceof Br){
						return PAGE_BREAK;
					}
				}else if(r.getContent().size() == 2){
					if (r.getContent().get(0) instanceof JAXBElement){
						Object obj = ((JAXBElement<?>) r.getContent().get(0)).getValue();
						if (obj instanceof R.LastRenderedPageBreak){
							return PAGE_BREAK;
						}
					}
				}
			}
		}
		return "";
	}
	
	public static void main(String[] args) throws Docx4JException{
		String sampleDocxPath = Appl.class.getClassLoader().getResource("Sample.docx").getPath();
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(sampleDocxPath));
		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
		List<Object> list = documentPart.getContents().getBody().getContent();
		for(Object obj: list){
			String type = parse(obj);
			System.out.println(type);
		}
	}
}
