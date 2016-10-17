package com.ittechoffice.spring.mockito;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ittechoffice.spring.mockito.model.SpringBean;
import com.ittechoffice.spring.mockito.model.SpringBeanConstructorArg;

public class XmlConfigHelper {
	
	public static String getMockBeanDefinition(Class clz) throws JAXBException{
		
		SpringBean springBean = new SpringBean();
		String mockitoFactoryBean = MockitoFactoryBean.class.getName();
		springBean.setMockitoFactoryBeanClass(mockitoFactoryBean);
		
		SpringBeanConstructorArg springBeanConstructorArg = new SpringBeanConstructorArg();
		springBeanConstructorArg.setValue(clz.getName());
		List<SpringBeanConstructorArg> springBeanConstructorArgList = new ArrayList<SpringBeanConstructorArg>();
		springBeanConstructorArgList.add(springBeanConstructorArg);
		springBean.setSpringBeanConstructorArgs(springBeanConstructorArgList);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(SpringBean.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		ByteArrayOutputStream outputStrem = new ByteArrayOutputStream();
		jaxbMarshaller.marshal(springBean, outputStrem);
		String result = outputStrem.toString();
		
		return result;
	}
	

}
