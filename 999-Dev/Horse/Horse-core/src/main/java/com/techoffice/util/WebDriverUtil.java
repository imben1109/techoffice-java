package com.techoffice.util;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techoffice.factory.WebDriverFactory;

public class WebDriverUtil {
	
	/**
	 * Get XML
	 * @param url
	 * @return xml 
	 */
	public static String getXml(String url){
		WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
		webDriver.get(url);
		String sourceStr = webDriver.getPageSource();
		webDriver.quit();
		org.jsoup.nodes.Document document = Jsoup.parse(sourceStr);
	    document.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
	    document.select("script").remove();
	    document.select("head").remove();
		String xml = document.html();
	    String tiddedXml = XmlUtil.tidyXml(xml);
		return tiddedXml;
	}
	
	/**
	 * Get the redirect url
	 * @param url
	 * @return url
	 */
	public static String getCurrentUrl(String url){
		WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
		webDriver.get(url);
		String currentUrl = webDriver.getCurrentUrl();
		webDriver.close();
		webDriver.quit();
		return currentUrl;
	}
	
	/**
	 * Get Source Code by Web Driver (PhantomJS) and convert into xhtml
	 * @param url
	 * @return
	 */
	public static String getRaceResultXml(String url) {
		WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
		webDriver.get(url);
	    WebDriverWait wait = new WebDriverWait(webDriver, 3);
	    String sourceStr = "";
	    try{
	    	wait.until((ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='results']"))));
			sourceStr = webDriver.getPageSource();
	    }catch(NoSuchElementException e){
	    	e.printStackTrace();
	    }catch(TimeoutException e){
	    	e.printStackTrace();
	    }finally{
	    	webDriver.quit();
	    }
		org.jsoup.nodes.Document document = Jsoup.parse(sourceStr);
	    document.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
	    document.select("script").remove();
	    String xml = document.html();
	    String tiddedXml = XmlUtil.tidyXml(xml);
		return tiddedXml;

	}
}
