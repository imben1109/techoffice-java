package com.techoffice.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;

import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

public class XmlUtil {
	
	private static Logger log = LoggerFactory.getLogger(XmlUtil.class);
	
	public static String covertNodeToXmlString(Node node) throws TransformerException{
		StringWriter writer = new StringWriter();
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(node), new StreamResult(writer));
		String xml = writer.toString();
		return xml;
	}
	
	public static Document convertXmlStrToDocument(String xml) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(false);
		documentBuilderFactory.setValidating(false);
		documentBuilderFactory.setFeature("http://xml.org/sax/features/namespaces", false);
		documentBuilderFactory.setFeature("http://xml.org/sax/features/validation", false);
		documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
		documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
		return document;
	}
	
	public static String tidyXml(String xml){
		Tidy tidy = new Tidy();
		tidy.setXmlTags(true);
		tidy.setXHTML(true);
		tidy.setQuiet(true);
		//
		tidy.setShowWarnings(true);
		tidy.setInputEncoding("UTF-8");
		tidy.setOutputEncoding("UTF-8");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		tidy.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)), out);
		String tiddiedXml = "";
		try {
			tiddiedXml = out.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		if (nodeList.getLength() > 1){
			throw new XmlUtilXpathNotUniqueException(xPath + " contains two node positions. " );
		}else if (nodeList.getLength() == 0){
			throw new XmlUtilXpathNotUniqueException(xPath + " cannot be found. "); 
		}else {
			Node node = nodeList.item(0);
			nodeText = getNodeText(node);
		}
		nodeText = SpecialStringUtil.removeSpecialCharacter(nodeText);
		return nodeText;
	}
	
	public static String getNodeText(Node node){
		String nodeText = "";
		NodeList nodeList = node.getChildNodes();
		if (nodeList.getLength() > 0){
			for (int i=0; i<nodeList.getLength(); i++){
				Node childNode = nodeList.item(i);
				if (childNode.getChildNodes().getLength() == 1 ){
					nodeText += " " + SpecialStringUtil.removeSpecialCharacter(childNode.getFirstChild().getNodeValue());
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
