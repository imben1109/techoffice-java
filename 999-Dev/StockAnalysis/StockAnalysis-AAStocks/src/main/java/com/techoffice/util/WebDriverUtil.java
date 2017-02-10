package com.techoffice.util;

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
	    document.select("script").remove();
	    String xml = document.html();
	    String tiddedXml = XmlUtil.tidyXml(xml);
		return tiddedXml;
	}
}
