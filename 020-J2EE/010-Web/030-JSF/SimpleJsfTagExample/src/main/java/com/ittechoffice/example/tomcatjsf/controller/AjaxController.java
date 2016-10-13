package com.ittechoffice.example.tomcatjsf.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AjaxController {
	private String inputTextValue;
	private String ajaxRetrunValue;
	public String getInputTextValue() {
		return inputTextValue;
	}
	public void setInputTextValue(String inputTextValue) {
		this.inputTextValue = inputTextValue;
		this.ajaxRetrunValue = "Updated: " + inputTextValue;
	}
	public String getAjaxRetrunValue() {
		return ajaxRetrunValue;
	}
	public void setAjaxRetrunValue(String ajaxRetrunValue) {
		this.ajaxRetrunValue = ajaxRetrunValue;
	}
	
}
