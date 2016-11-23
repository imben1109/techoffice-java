package com.ittechoffice.example.model;

/**
 * File Explorer File
 *
 */
public class FeFile {
	private String name;
	private String parent;
	private FeFileType type;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public FeFileType getType() {
		return type;
	}

	public void setType(FeFileType type) {
		this.type = type;
	}

	public enum FeFileType {
		FILE("FILE"), FOLDER("FOLDER");
		private String name;
		FeFileType(String name){
			this.name = name;
		}
		@Override
		public String toString(){
			return name;
		}
	}	
	
}
