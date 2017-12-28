package com.techoffice.util;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings.Syntax;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * 
 */
public class WebDriverUtil {
	
	private static Logger log = LoggerFactory.getLogger(WebDriverUtil.class);
	
	private WebDriverUtil(){}
	
	private static Properties PROPERTIES = new Properties();
	
	static{
		try {
			URL url = WebDriverUtil.class.getClassLoader().getResource("WebDriverUtil.properties");
			if (url != null){
				PROPERTIES.load(WebDriverUtil.class.getClassLoader().getResourceAsStream("WebDriverUtil.properties"));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
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
	 * @param url
	 * @param expectedCondition
	 * @return Xml Content of url
	 */
	public static String getXml(String url, ExpectedCondition<WebElement> expectedCondition) {
		return getXml(url, expectedCondition, false);
	}
	
	/**
	 * Get Xml Content 
	 * 
	 * @param url
	 * @param scrollDown
	 * @return Xml Content of url
	 */
	public static String getXml(String url, boolean scrollDown) {
		return getXml(url, null, scrollDown);
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
	public static String getXml(String url, ExpectedCondition<WebElement> expectedCondition, boolean scrollDown) {
		if (WebDriverUtilXmlCache.get(url) == null){
			WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
			webDriver.get(url);
		    WebDriverWait wait = new WebDriverWait(webDriver, 3);
		    String sourceStr = "";
		    if (expectedCondition != null){
		    	try{
		    		wait.until(expectedCondition);
		    		if (scrollDown){
			    		scrollToBottom(webDriver);
			    	}
		    		sourceStr = webDriver.getPageSource();
		    	}catch(Exception e){
		    		throw new WebDriverUtilException(e);
		    	}finally{
		    		webDriver.quit();
		    	}
		    }else {
		    	if (scrollDown){
		    		scrollToBottom(webDriver);
		    	}
		    	sourceStr = webDriver.getPageSource();
				webDriver.quit();
		    }
		    String tiddedXml = getTiddedXmlFromSource(sourceStr);
		    WebDriverUtilXmlCache.put(url, tiddedXml);
			return tiddedXml;
		}else {
			return WebDriverUtilXmlCache.get(url);
		}
	}
	
	/**
	 * Scroll to Bottom
	 * 
	 * @param webDriver
	 */
	public static void scrollToBottom(WebDriver webDriver){
		if (webDriver instanceof JavascriptExecutor){
			JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
			Object newscrollTop = jsExecutor.executeScript("return document.body.scrollHeight", "");
			Object scrollTop = jsExecutor.executeScript("return document.body.scrollTop", "");
			while(!newscrollTop.equals(scrollTop)){
				scrollTop = jsExecutor.executeScript("return document.body.scrollTop", "");
				jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);", "");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
				newscrollTop = jsExecutor.executeScript("return document.body.scrollTop", "");
				System.out.println(newscrollTop + " " + scrollTop);
			}
		}
	}
	

	/**
	 * Get Xml from Source String 
	 * 
	 * @param sourceStr Source String
	 * @return Xml 
	 */
	public static String getTiddedXmlFromSource(String sourceStr){
		Document document = Jsoup.parse(sourceStr);
	    document.outputSettings().syntax(Syntax.xml);
	    document.outputSettings().charset(StandardCharsets.UTF_8);
	    document.outputSettings().prettyPrint(true);
	    document.select("head").remove();
	    document.select("script").remove();
	    document.select("style").remove();
	    String xml = document.html();
	    List<String> specialTokenList = getSpecialTokenListToRemove();
	    for (String specialToken: specialTokenList ){
	    	xml = xml.replace(specialToken, "");
	    }
		return xml;
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
	
	public static List<String> getSpecialTokenListToRemove(){
		List<String> specialTokenList = new ArrayList<String>();
		String specialTokens = PROPERTIES.getProperty("special_tokens", "");
		String[] specialTokenArr = specialTokens.split(",");
		for (int i=0; i<specialTokenArr.length; i++){
			String specialToken = specialTokenArr[i];
			specialTokenList.add(specialToken.trim());
		}
		return specialTokenList;
	}
	
}
