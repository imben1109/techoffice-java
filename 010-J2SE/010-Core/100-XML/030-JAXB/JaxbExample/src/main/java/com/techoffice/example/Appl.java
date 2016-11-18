package com.ittechoffice.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Appl {
	
	public static void main(String[] args) throws JAXBException{
		User user = new User();
		user.setName("Test User");
		user.setAge(10);
		JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(user, System.out);
	}
	
}
