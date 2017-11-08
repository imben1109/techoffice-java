package com.techoffice.util;

import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
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
	    document.select("meta").remove();
	    document.select("head").remove();
	    document.select("style").remove();
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
