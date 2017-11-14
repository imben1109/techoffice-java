package com.techoffice.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class Appl {
	public static void main(String[] args) throws IOException, ParseException, ParserConfigurationException, SAXException{
		URL onccNewsRssUrl = new URL("http://news.on.cc/ncnews/rss/fin_news.xml");
//		BufferedReader br = new BufferedReader(new InputStreamReader(onccNewsRssUrl.openStream(), StandardCharsets.UTF_8));
//		String line = "";
//		while ( (line = br.readLine()) != null){
//			System.out.println(line);
//		}
		InputStream inputStream = onccNewsRssUrl.openStream();
		InputSource inputSource = new InputSource(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(inputSource);
		NodeList nodeList = document.getElementsByTagName("description");
		for (int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			System.out.println(node.getTextContent());
		}
	}
}
