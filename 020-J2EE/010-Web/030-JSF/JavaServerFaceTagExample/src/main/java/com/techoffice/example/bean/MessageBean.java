package com.ittechoffice.example.tomcatjsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ittechoffice.example.tomcatjsf.model.TextModel;

@ManagedBean(name="messageBean")
@ApplicationScoped
public class MessageBean {
	private List<TextModel> textList = new ArrayList<TextModel>();

	public List<TextModel> getTextList() {
		return textList;
	}

	public void setTextList(List<TextModel> textList) {
		this.textList = textList;
	}
	
	public void addToList(String sessionId, String color) {
		textList.add(makeTextModel(sessionId, color));
		
	}
	
	private TextModel makeTextModel(String sessionId, String color) {
		return new TextModel("User with session ID of " + sessionId + " selected color \"" + color + "\".",
						     color);
	}
}
