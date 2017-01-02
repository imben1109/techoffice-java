package com.techoffice.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.h2.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;

import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

public class XmlUtil {
	
	public static String covertNodeToXmlString(Node node) throws TransformerException{
		StringWriter writer = new StringWriter();
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(node), new StreamResult(writer));
		String xml = writer.toString();
		return xml;
	}
	
	public static Document convertXmlStrToDocument(String xml) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		String tiddedXml = tidyXml(xml);
		Document document = documentBuilder.parse(new ByteArrayInputStream(tiddedXml.getBytes()));
		return document;
	}
	
	public static String tidyXml(String xml){
		Tidy tidy = new Tidy();
		tidy.setXmlTags(true);
		tidy.setInputEncoding("UTF-8");
		tidy.setOutputEncoding("UTF-8");
		OutputStream out = new ByteArrayOutputStream();
		tidy.parse(new ByteArrayInputStream(xml.getBytes()), out);
		String tiddiedXml = out.toString();
		return tiddiedXml;
	}
	
	public static NodeList evaluateXpath(String xml, String xPath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
		Document doc = convertXmlStrToDocument(xml);
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile(xPath);
		NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		return nodeList;
	}
	
	public static String getXpathText(String xml, String xPath) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XmlUtilXpathNotUniqueException{
		String nodeText = "";
		NodeList nodeList = evaluateXpath(xml, xPath);
		if (nodeList.getLength() != 1){
			throw new XmlUtilXpathNotUniqueException(xPath + " contains two node positions. " );
		}else {
			Node node = nodeList.item(0);
			nodeText = getNodeText(node);
		}
		nodeText = StringUtil.removeSpecialCharacter(nodeText);
		return nodeText;
	}
	
	public static String getNodeText(Node node){
		String nodeText = "";
		NodeList nodeList = node.getChildNodes();
		if (nodeList.getLength() > 0){
			for (int i=0; i<nodeList.getLength(); i++){
				Node childNode = nodeList.item(i);
				if (childNode.getChildNodes().getLength() == 1 ){
					nodeText += " " + StringUtil.removeSpecialCharacter(childNode.getFirstChild().getNodeValue());
				}else {
					nodeText += " " + getNodeText(childNode);
				}
			}
		}else{
			nodeText += " " + node.getTextContent();
		}
		nodeText = nodeText.trim();
		return nodeText;
	}
	
}
