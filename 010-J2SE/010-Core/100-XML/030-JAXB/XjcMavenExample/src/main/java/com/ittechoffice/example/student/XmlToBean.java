package com.ittechoffice.example.student;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.ittechoffice.example.student.model.Student;

public class XmlToBean {
	public static void main(String[] args) throws JAXBException {
		InputStream stream = XmlToBean.class.getClassLoader().getResourceAsStream("student.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StreamSource streamSource = new StreamSource(stream);
		JAXBElement<Student> studentJaxbElement = jaxbUnmarshaller.unmarshal(streamSource, Student.class);
		Student student = studentJaxbElement.getValue();
		System.out.println(student.getName());
	}
}
