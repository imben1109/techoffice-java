package com.techoffice.util;

import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techoffice.factory.WebDriverFactory;
import com.techoffice.util.cache.WebDriverUtilRedirectUrlCache;
import com.techoffice.util.cache.WebDriverUtilXmlCache;
import com.techoffice.util.exception.WebDriverUtilException;

/**
 * Web Driver Utility
 * 
 * It support cache for improving performance. 
 * 
 * WebDriverUtilXmlCache would be used for cache of XML content of specified url
 * WebDriverUtilRedirectUrlCache  would be used for cache of redirected url of specified url.
 * 
 * @author TechOffice
 *
 */
public class WebDriverUtil {
	
	/**
	 * Get XML Content 
	 * 
	 * It support cache for improving performance.
	 * The XML content would be cached in WebDriverUtilXmlCache.
	 * 
	 * @param url for retrieving xml content
	 * @return Xml content of url
	 */
	public static String getXml(String url){
		return getXml(url, null);
	}
	
	/**
	 * Get XML Content 
	 * 
	 * It support cache for improving performance.
	 * The XML content would be cached in WebDriverUtilXmlCache.
	 * 
	 * @param url for retrieving xml content
	 * @param expectedCondition Expected Condition for Web Client to wait.
	 * 
	 * @return Xml content of url
	 */
	public static String getXml(String url, ExpectedCondition<WebElement> expectedCondition) {
		if (WebDriverUtilXmlCache.get(url) == null){
			WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
			webDriver.get(url);
		    WebDriverWait wait = new WebDriverWait(webDriver, 3);
		    String sourceStr = "";
		    if (expectedCondition != null){
		    	try{
		    		wait.until(expectedCondition);
		    		sourceStr = webDriver.getPageSource();
		    	}catch(Exception e){
		    		throw new WebDriverUtilException(e);
		    	}finally{
		    		webDriver.quit();
		    	}
		    }else {
		    	sourceStr = webDriver.getPageSource();
				webDriver.quit();
		    }
			org.jsoup.nodes.Document document = Jsoup.parse(sourceStr);
		    document.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
		    document.select("script").remove();
		    document.select("head").remove();
		    String xml = document.html();
		    String tiddedXml = XmlUtil.tidyXml(xml);
		    WebDriverUtilXmlCache.put(url, tiddedXml);
			return tiddedXml;
		}else {
			return WebDriverUtilXmlCache.get(url);
		}
	}
	
	/**
	 * Get the redirect url
	 * 
	 * It support cache (WebDriverUtilRedirectUrlCache)for improving performance 
	 * 
	 * @param url
	 * @return redirected url
	 */
	public static String getRedirectUrl(String url){
		if (WebDriverUtilRedirectUrlCache.get(url) == null){
			WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
			webDriver.get(url);
			String redirectUrl = webDriver.getCurrentUrl();
			webDriver.close();
			webDriver.quit();
			return redirectUrl;
		}else {
			return WebDriverUtilRedirectUrlCache.get(url);
		}
	}
	
}
