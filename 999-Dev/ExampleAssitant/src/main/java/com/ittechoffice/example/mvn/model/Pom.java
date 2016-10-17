package com.ittechoffice.example.mvn.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pom {
	private String modelVersion;
	private String groupId;
	private String actifactId;
	private String version;
	public String getModelVersion() {
		return modelVersion;
	}
	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getActifactId() {
		return actifactId;
	}
	public void setActifactId(String actifactId) {
		this.actifactId = actifactId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
