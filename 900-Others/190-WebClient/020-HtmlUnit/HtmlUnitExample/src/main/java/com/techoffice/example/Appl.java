package com.techoffice.example;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Appl {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
	    final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        final String pageAsXml = page.asXml();
        System.out.println(pageAsXml);
        webClient.close();
	}
}
