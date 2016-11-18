package com.ittechoffice.example.student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ittechoffice.example.student.model.ObjectFactory;
import com.ittechoffice.example.student.model.Student;

public class BeanToXml {
	public static void main(String[] args) throws JAXBException{
		Student student = new Student();
		student.setName("testing");
		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<Student> element = objectFactory.createStudent(student);
		
	
		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(element, System.out);
	}
}
