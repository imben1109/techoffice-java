package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DocumentFactory {
	
	public static void setIdAttribute(NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nodeList.item(i);
				if (element.hasAttribute("id")) {
					element.setIdAttribute("id", true);
				}
				if (element.getChildNodes().getLength() > 0) {
					setIdAttribute(element.getChildNodes());
				}
			}
		}
	}

	public static Document createDocument(File file) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		NodeList nodeList = doc.getChildNodes();
		setIdAttribute(nodeList);
		return doc;
	}
}
