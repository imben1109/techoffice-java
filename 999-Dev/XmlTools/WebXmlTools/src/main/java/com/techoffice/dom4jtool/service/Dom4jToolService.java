package com.techoffice.dom4jtool.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.techoffice.dom4jtool.util.Dom4jUtil;

@Service
public class Dom4jToolService {
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> getMapFromElement(Element rootElement){
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<Element> iterator = rootElement.elementIterator();
		while(iterator.hasNext()){
			Element element = iterator.next();
			Map<String, Object> elementMap = getMapFromElement(element);
			map.put(element.getName(), elementMap);			
		}
		return map;
	}
	
	public Map<String, Object> parse(String xml) throws DocumentException{
		Map<String, Object> map = new HashMap<String, Object>();
		Document document = Dom4jUtil.parse(xml);
		
		Element rootElement = document.getRootElement();
		Map<String, Object> tagNameMap = getMapFromElement(rootElement);
		
		String parsedXml =  document.asXML();
		
		map.put("xml", parsedXml);
		map.put("tag", tagNameMap);
		return map;
	}
	
	public List queryByXpath(String xml, String xpath) throws DocumentException{
		Document document = Dom4jUtil.parse(xml);
		List list = document.selectNodes(xpath);
		return list;
	}
}
