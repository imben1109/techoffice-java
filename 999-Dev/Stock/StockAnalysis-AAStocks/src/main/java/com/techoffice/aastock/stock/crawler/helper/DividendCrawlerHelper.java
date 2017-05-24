package com.techoffice.aastock.stock.crawler.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DividendCrawlerHelper {
	
	public static Date getDate(String str) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = simpleDateFormat.parse(str);
		return date;
	}
	
	public static Date getMonth(String str) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
		Date date = simpleDateFormat.parse(str);
		return date;
	}
}
