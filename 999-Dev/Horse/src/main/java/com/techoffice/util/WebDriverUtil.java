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
	 * Get Source Code by Web Driver (PhantomJS) and convert into xhtml
	 * @param url
	 * @return
	 */
	public static String getXml(String url) {
		WebDriver webDriver = WebDriverFactory.getPhantomJSDriver();
		webDriver.get(url);
	    WebDriverWait wait = new WebDriverWait(webDriver, 3);
	    try{
	    	wait.until((ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='results']/div[5]/div[2]/table"))));
			String sourceStr = webDriver.getPageSource();
			webDriver.quit();
			org.jsoup.nodes.Document document = Jsoup.parse(sourceStr);
		    document.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
		    document.select("script").remove();
		    String xml = document.html();
		    String tiddedXml = XmlUtil.tidyXml(xml);
			return tiddedXml;
	    }catch(NoSuchElementException e){
	    	e.printStackTrace();
	    }catch(TimeoutException e){
	    	e.printStackTrace();
	    }
	    return null;
	}
}
