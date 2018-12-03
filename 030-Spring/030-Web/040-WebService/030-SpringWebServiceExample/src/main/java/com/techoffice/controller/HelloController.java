package com.techoffice.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloController {
	
	@PayloadRoot(localPart = "sayHi")
	@ResponsePayload
	public String sayHi(){
		return "Hi!";
	}
}
