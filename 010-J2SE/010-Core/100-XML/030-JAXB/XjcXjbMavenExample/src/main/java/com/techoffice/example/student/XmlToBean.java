package com.techoffice.example.student;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.techoffice.example.student.model.Student;

public class XmlToBean {

	private static final String url = "com.techoffice.example.student.model";

	public static void main(String[] args) throws JAXBException {
		InputStream stream = XmlToBean.class.getClassLoader().getResourceAsStream("student.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(url);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StreamSource streamSource = new StreamSource(stream);
		JAXBElement<Student> studentJaxbElement = jaxbUnmarshaller.unmarshal(streamSource, Student.class);
		Student student = studentJaxbElement.getValue();
		System.out.println(student.getStudentName());
	}
}
