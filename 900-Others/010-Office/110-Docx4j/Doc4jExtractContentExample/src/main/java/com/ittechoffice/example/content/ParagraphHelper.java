package com.ittechoffice.example.content;

import java.io.File;
import java.util.List;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;

import com.ittechoffice.example.Appl;

public class ParagraphHelper {
	private static final String STYLE= "STYLE";
	private static final String LIST = "LIST";
	private static final String TEXT = "TEXT";
	
	public static String parse(P p ){
		if (p.getPPr() != null){
			PPr ppr = p.getPPr();
			if (ppr.getNumPr() != null){
				return LIST;
			}else if (ppr.getPStyle() != null){
				return STYLE;
			}
		}
		return TEXT;
	}
	
	public static void main(String[] args) throws Docx4JException{
		String sampleDocxPath = Appl.class.getClassLoader().getResource("Sample.docx").getPath();
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(sampleDocxPath));
		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
		List<Object> list = documentPart.getContents().getBody().getContent();
		for(Object obj: list){
			String type = ContentParser.parse(obj);
			if (type.equals(ContentParser.TEXT_PARAGRAPH)){
				String pType = ParagraphHelper.parse((P) obj);
				System.out.println(pType);
			}else{
				System.out.println(type);
			}
			
		}
	}
}
