package com.techoffice.example;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Component
public class Appl {
	
	@Autowired
	private WebClient webClient;
	
	public void run() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
		System.out.println(page.asXml());
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
