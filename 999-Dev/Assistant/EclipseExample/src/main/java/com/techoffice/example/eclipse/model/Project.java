package com.techoffice.example.eclipse.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "projectDescription")
public class Project {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
