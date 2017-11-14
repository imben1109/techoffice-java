package com.techoffice.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class Appl {
	public static void main(String[] args) throws URISyntaxException, IOException{
		URI uri = new URI("https", "www.oracle.com", "/index.html", "");
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(uri.toURL().openStream()));
		String line ;
		while((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}
		bufferedReader.close();
	}
}
