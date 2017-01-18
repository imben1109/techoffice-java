package com.ittechoffice.spring.mockito.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="bean")
public class SpringBean {
    
    @XmlAttribute(name="class")
	private String mockitoFactoryBeanClass;

    @XmlElement(name="constructor-arg")
	private List<SpringBeanConstructorArg> SpringBeanConstructorArgs;

	public String getMockitoFactoryBeanClass() {
		return mockitoFactoryBeanClass;
	}

	public void setMockitoFactoryBeanClass(String mockitoFactoryBeanClass) {
		this.mockitoFactoryBeanClass = mockitoFactoryBeanClass;
	}

	public List<SpringBeanConstructorArg> getSpringBeanConstructorArgs() {
		return SpringBeanConstructorArgs;
	}

	public void setSpringBeanConstructorArgs(List<SpringBeanConstructorArg> springBeanConstructorArgs) {
		SpringBeanConstructorArgs = springBeanConstructorArgs;
	}
	
	
}
