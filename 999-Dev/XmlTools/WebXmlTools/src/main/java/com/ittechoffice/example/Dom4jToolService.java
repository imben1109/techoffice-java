package com.ittechoffice.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dom4jToolService {
	
	@Autowired
	private Dom4jHelper dom4jHelper;
	
	public Map<String, Object> parse(String xml) throws DocumentException{
		Map<String, Object> map = new HashMap<String, Object>();
		Document document = dom4jHelper.parse(xml);
		String parsedXml =  document.asXML();
		map.put("xml", parsedXml);
		return map;
	}
	
	public List queryByXpath(String xml, String xpath) throws DocumentException{
		Document document = dom4jHelper.parse(xml);
		List list = document.selectNodes(xpath);
		return list;
	}
}
