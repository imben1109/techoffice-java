package com.ittechoffice.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ittechoffice.example.sse.SseEmitterManager;

@Controller
public class SimpleController {
		
	@Autowired
    private SseEmitterManager sseEmitterManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model){
		return "home";		
	}
	
	@RequestMapping(value ="/emit")
	public SseEmitter  handle() {
	    return sseEmitterManager.createEmitter();
	}

	@RequestMapping(value="/send", method = RequestMethod.GET)
	@ResponseBody
	public String send(@RequestParam("message") String message) throws IOException{
		sseEmitterManager.send(message);
		return message;
	}
	
}
