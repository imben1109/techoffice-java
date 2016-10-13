package com.ittechoffice.example.content;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.R;
import org.docx4j.wml.Text;

import com.ittechoffice.example.Appl;

/**
 * 
 * Content in Simple.docx
 * --------------------------------------
 * Paragraph
 * 
 * Bold Text
 * Title 1
 * Title 2
 * <Table Object>
 * 
 * <List Object>
 * <Break Line Object>
 * Page 2 after page separator
 * --------------------------------------
 * 
 * Output 
 * --------------------------------------
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.Text
 *         Paragraph
 * org.docx4j.wml.P
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.Text
 *         Bold Text
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.Text
 *         Title 1
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.Text
 *         Title 2
 * javax.xml.bind.JAXBElement
 *   class org.docx4j.wml.Tbl
 * org.docx4j.wml.P
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.Text
 *         List 1
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.Text
 *         List 1
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.Text
 *         List 1
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class org.docx4j.wml.Br
 * org.docx4j.wml.P
 *   class org.docx4j.wml.R
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.R$LastRenderedPageBreak
 *     class javax.xml.bind.JAXBElement
 *       class org.docx4j.wml.Text
 *         Page 2 after page separator
 * org.docx4j.wml.P
 * --------------------------------------
 * 
 * @author Ben_c
 *
 */
public class ContentClassExample {
	public static void main(String[] args) throws Exception{
		String sampleDocxPath = Appl.class.getClassLoader().getResource("Sample.docx").getPath();
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(sampleDocxPath));
		
		
		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
		
		List<Object> list = documentPart.getContents().getBody().getContent();
		for(Object obj: list){
			System.out.println(obj.getClass().getName());
			if (obj instanceof P){
				P p = (P) obj;
				List<Object> subList = p.getContent();
				for (Object subObject: subList){
					System.out.println("  " + subObject.getClass());
					if (subObject instanceof R){
						R r = (R) subObject;
						List<Object> subSubList = r.getContent();
						for (Object subSubObj: subSubList){
							System.out.println("    " + subSubObj.getClass());
							if (subSubObj instanceof JAXBElement){
								JAXBElement<?> element = (JAXBElement<?>) subSubObj;
								Object subsubsubObj = element.getValue();
								System.out.println("      " + subsubsubObj.getClass());
								if (subsubsubObj instanceof Text){
									Text text = (Text) subsubsubObj;
									System.out.println("        " + text.getValue());
								}
							}
						}
					}
				}
			}
			if (obj instanceof JAXBElement){
				JAXBElement<?> element = (JAXBElement<?>) obj;
				System.out.println("  " + element.getValue().getClass().toString());
			}
		}
		
	}
}
