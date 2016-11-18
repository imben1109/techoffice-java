package com.ittechoffice.example;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Appl {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
		InputStream is = Appl.class.getClassLoader().getResourceAsStream("sample2.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(is);
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		// XPath (//) define arbitrary depth
//		XPathExpression expr = xpath.compile("//value");
		XPathExpression expr = xpath.compile("/html/body/center/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td/table/tbody/tr/td[2]/printfriendly/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[4]/td[1]");
		NodeList tableNodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		String content = tableNodeList.item(0).getTextContent();
		System.out.println(content);
	}
}
