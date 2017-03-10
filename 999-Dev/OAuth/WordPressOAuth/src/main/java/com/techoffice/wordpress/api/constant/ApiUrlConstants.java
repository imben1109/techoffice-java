package com.techoffice.wordpress.api.constant;

import java.text.MessageFormat;

public class ApiUrlConstants {
	
	public static final String ME_SITES = "https://public-api.wordpress.com/rest/v1.1/me/sites";
	
	public static final String SITES_SITE_POST = "https://public-api.wordpress.com/rest/v1.1/sites/{0}/posts/";
	public static final String SITES_SITE_POSTCOUNTS = "https://public-api.wordpress.com/rest/v1.1/sites/{0}/post-counts/{1}";
	
	public static void main(String[] args){
		System.out.println(MessageFormat.format(SITES_SITE_POST, 1));
	}
}
