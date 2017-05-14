package com.techoffice.util;

import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.techoffice.factory.WebDriverFactory;

public class WebDriverUtil {
	
	/**
	 * Get Source Code by Web Driver (PhantomJS) and convert into xhtml
	 * @param url URL
	 * @return Xml Content
	 */
	public static String getXml(String url){
		WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
		webDriver.get(url);
		String sourceStr = webDriver.getPageSource();
		webDriver.quit();
		org.jsoup.nodes.Document document = Jsoup.parse(sourceStr);
	    document.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
	    document.outputSettings().charset(StandardCharsets.UTF_8);
	    document.select("script").remove();
	    document.select("style").remove();
	    document.select("head").remove();
	    document.select("canvas").remove();
	    document.select("svg").remove();
	    document.select("path").remove();
	    document.select("nav").remove();
	    String xml = document.html();
	    String tiddedXml = XmlUtil.tidyXml(xml);
	    tiddedXml = SpecialStringUtil.removeIllegalXml(tiddedXml);
		return tiddedXml;
	}
	
	public static String getXmlScrollDown(String url){
		WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
		webDriver.get(url);
		if (webDriver instanceof JavascriptExecutor){
			JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
			Object newscrollTop = jsExecutor.executeScript("return document.body.scrollHeight", "");
			Object scrollTop = jsExecutor.executeScript("return document.body.scrollTop", "");
			while(!newscrollTop.equals(scrollTop)){
				scrollTop = jsExecutor.executeScript("return document.body.scrollTop", "");
				jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);", "");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
				newscrollTop = jsExecutor.executeScript("return document.body.scrollTop", "");
				System.out.println(newscrollTop + " " + scrollTop);
			}
		}
		String sourceStr = webDriver.getPageSource();
		webDriver.quit();
		org.jsoup.nodes.Document document = Jsoup.parse(sourceStr);
	    document.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
	    document.outputSettings().charset(StandardCharsets.UTF_8);
	    document.select("script").remove();
	    document.select("style").remove();
	    document.select("head").remove();
	    document.select("canvas").remove();
	    document.select("svg").remove();
	    document.select("path").remove();
	    document.select("nav").remove();
	    String xml = document.html();
	    String tiddedXml = XmlUtil.tidyXml(xml);
	    tiddedXml = SpecialStringUtil.removeIllegalXml(tiddedXml);
		return tiddedXml;
	}
}
