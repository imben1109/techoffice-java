package com.ittechoffice.example.tomcatjsf.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BasicTagController {
	private String selectManyCheckboxValue;
	private String selectOneRadioValue;
	private String selectOneListboxValue;
	private String selectManyListboxValue;
	private String selectOnRadioValue;

	public String getSelectManyCheckboxValue() {
		return selectManyCheckboxValue;
	}

	public void setSelectManyCheckboxValue(String selectManyCheckboxValue) {
		this.selectManyCheckboxValue = selectManyCheckboxValue;
	}

	public String getSelectOneRadioValue() {
		return selectOneRadioValue;
	}

	public void setSelectOneRadioValue(String selectOneRadioValue) {
		this.selectOneRadioValue = selectOneRadioValue;
	}

	public String getSelectOneListboxValue() {
		return selectOneListboxValue;
	}

	public void setSelectOneListboxValue(String selectOneListboxValue) {
		this.selectOneListboxValue = selectOneListboxValue;
	}

	public String getSelectManyListboxValue() {
		return selectManyListboxValue;
	}

	public void setSelectManyListboxValue(String selectManyListboxValue) {
		this.selectManyListboxValue = selectManyListboxValue;
	}

	public String getSelectOnRadioValue() {
		return selectOnRadioValue;
	}

	public void setSelectOnRadioValue(String selectOnRadioValue) {
		this.selectOnRadioValue = selectOnRadioValue;
	}
	
	
	
	
	
}
