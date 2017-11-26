package com.techoffice.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.util.exception.UrlUtilException;

public class UrlUtil {

	public static List<String> getContentList(String urlStr){
		List<String> contentList = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL(urlStr);
			InputStream inputStream = url.openStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			String line = null;
			while ( (line = bufferedReader.readLine()) != null){
				contentList.add(line);
			}
		} catch (Exception e){ 
			throw new UrlUtilException(e);
		}finally{
			if (bufferedReader != null){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// do nothing
				}
			}
		}
		return contentList;
	}
}
