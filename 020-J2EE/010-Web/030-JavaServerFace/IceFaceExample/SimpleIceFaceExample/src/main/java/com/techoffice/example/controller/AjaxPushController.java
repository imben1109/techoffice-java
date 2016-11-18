package com.ittechoffice.example.tomcaticefaces.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.icefaces.application.PushRenderer;

import com.ittechoffice.example.tomcaticefaces.bean.MessageBean;

@ManagedBean
@ViewScoped
public class AjaxPushController {
	
	@ManagedProperty(value="#{messageBean}")
	private MessageBean messageBean;
	
	private String sessionId;
	
	private static final String PUSH_GROUP = "colorPage";
	private String color = "black";
	
	public AjaxPushController() {
		PushRenderer.addCurrentSession(PUSH_GROUP);

		FacesContext fcontext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)fcontext.getExternalContext().getSession(false);
		sessionId = session.getId();
	}
	
	public String chooseColor() {
		messageBean.addToList(sessionId, color);
		PushRenderer.render(PUSH_GROUP);
		return null;
	}
	
	public void setMessageBean(MessageBean messageBean){
		this.messageBean = messageBean;
		
	}

}
