package com.techoffice.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleDom4jExample {

	public static void main(String[] args) throws JsonProcessingException {
		String xml = "<?xml version='1.0'?><Test><name>Content</name></Test>";
		XmlMapper xmlMapper = new XmlMapper();
		Test test = xmlMapper.readValue(xml, Test.class);
		log.info("test name: {}", test.getName());
	}
}
