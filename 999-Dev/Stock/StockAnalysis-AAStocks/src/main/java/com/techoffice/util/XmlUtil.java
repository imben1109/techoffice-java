package com.techoffice.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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

import org.eclipse.jetty.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

import com.techoffice.util.exception.DocumentConversionException;
import com.techoffice.util.exception.XmlUtilTidyException;
import com.techoffice.util.exception.XmlUtilTransformerException;
import com.techoffice.util.exception.XpathException;

public class XmlUtil {
	
	private static Logger log = LoggerFactory.getLogger(XmlUtil.class);
	
	public static String covertNodeToXmlString(Node node) {
		try{
			StringWriter writer = new StringWriter();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(new DOMSource(node), new StreamResult(writer));
			String xml = writer.toString();
			return xml;
		}catch(TransformerException e){
			throw new XmlUtilTransformerException(e);
		}
	}
	
	/**
	 * 
	 * @param xml
	 * @return
	 * @throws DocumentConversionException
	 */
	public static Document convertXmlStrToDocument(String xml) {
		Document document = null;
		if (StringUtil.isNotBlank(xml)){
			try{
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				documentBuilderFactory.setNamespaceAware(false);
				documentBuilderFactory.setValidating(false);
				documentBuilderFactory.setFeature("http://xml.org/sax/features/namespaces", false);
				documentBuilderFactory.setFeature("http://xml.org/sax/features/validation", false);
				documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
				documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
				DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				document = documentBuilder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));	
			}catch(Exception e){
				log.error("Try to convert xml: " + xml);
				throw new DocumentConversionException("Cannot xml to Document: " + e.getMessage(), e);
			}
		}else {
			throw new DocumentConversionException("Empty Xml");
		}
		return document;
	}
	
	public static String tidyXml(String xml){
		xml = SpecialStringUtil.replaceSpecialAuotationMark(xml);
		Tidy tidy = new Tidy();
		tidy.setShowWarnings(false);
		tidy.setBreakBeforeBR(false);
		tidy.setIndentAttributes(true);
		tidy.setInputEncoding("UTF-8");
		tidy.setOutputEncoding("UTF-8");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		tidy.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)), out);
		int parseErrorsNum = tidy.getParseErrors();
		if (parseErrorsNum > 0){
			throw new XmlUtilTidyException("Tidy cannot parse xml");
		}
		String tiddiedXml = "";
		try {
			tiddiedXml = out.toString("UTF-8");
		} catch (Exception e){
			throw new XmlUtilTidyException(e);
		}
		return tiddiedXml;
	}
	
	/**
	 * 
	 * @param xml
	 * @param xPath
	 * @return
	 */
	public static NodeList evaluateXpath(String xml, String xPath){
		NodeList nodeList = null;
		Document doc = null;
		try {
			doc = convertXmlStrToDocument(xml);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr;
			expr = xpath.compile(xPath);
			nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		} catch (DocumentConversionException e) {
			throw new XpathException(e);
		} catch (XPathExpressionException e) {
			throw new XpathException(MessageFormat.format(XpathException.INVALID_XPATH_PATTERN, xPath), e);
		}
		return nodeList;	
	}
	
	/**
	 * 
	 * @param xml
	 * @param xPath
	 * @return
	 */
	public static String getXpathText(String xml, String xPath) {
		String nodeText = "";
		NodeList nodeList = evaluateXpath(xml, xPath);
		if (nodeList.getLength() > 1){
			throw new XpathException(MessageFormat.format(XpathException.NOT_UNIQUE_PATTERN, xPath));
		}else if (nodeList.getLength() == 0 ){
			log.error(xml);
			throw new XpathException(MessageFormat.format(XpathException.NOT_FOUND_PATTERN, xPath));
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
