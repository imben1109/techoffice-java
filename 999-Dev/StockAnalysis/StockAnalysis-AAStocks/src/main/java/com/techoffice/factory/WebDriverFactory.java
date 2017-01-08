package com.techoffice.factory;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class WebDriverFactory {
	
	static {
		File chromeDriverFile = new File("chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
		File phantomJsPath = new File("phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		System.setProperty("phantomjs.binary.path", phantomJsPath.getAbsolutePath());
	}
	
	public static WebDriver getChormeDriver(){
		WebDriver webDriver = new ChromeDriver();
		return webDriver;
	}
	
	public static WebDriver getPhantomJSDriver(){
		WebDriver webDriver = new PhantomJSDriver();
		return webDriver;
	}
	
}
