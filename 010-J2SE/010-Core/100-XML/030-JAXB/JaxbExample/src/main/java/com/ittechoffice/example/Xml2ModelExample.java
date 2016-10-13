package com.ittechoffice.example;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Xml2ModelExample {
	public static void main(String[] args) throws JAXBException{
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user><age>10</age><name>Test User</name></user>";
		InputStream stream = new ByteArrayInputStream(xml.getBytes());

		JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		User user = (User) jaxbUnmarshaller.unmarshal(stream);
		System.out.println(user.getAge());
		System.out.println(user.getName());

	}
}
