package com.techoffice.example;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class Appl {
	
	public static String USE_SYSTEM_PROXIES = "java.net.useSystemProxies";

	public static void main(String[] args) throws IllegalArgumentException, FeedException, IOException{
		System.setProperty(USE_SYSTEM_PROXIES, "true");

		URL feedUrl = new URL("https://hk.news.yahoo.com/rss/hong-kong");
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(feedUrl));
		List entries = feed.getEntries();
        for (Object entry: entries){
        	if (entry instanceof SyndEntry){
        		SyndEntry syndFeedEntry = (SyndEntry) entry;
        		System.out.println("Title: " + syndFeedEntry.getTitle());
        		System.out.println("Description: " + syndFeedEntry.getDescription().getValue());
        		System.out.println("===");
        	}
        }

	}

}
