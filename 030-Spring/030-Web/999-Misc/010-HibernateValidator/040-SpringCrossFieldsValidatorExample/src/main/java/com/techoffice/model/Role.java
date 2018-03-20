package com.techoffice.model;

import javax.validation.constraints.NotNull;

public class Role {
	
	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
