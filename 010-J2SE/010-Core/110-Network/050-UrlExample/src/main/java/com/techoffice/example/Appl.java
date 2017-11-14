package com.techoffice.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Appl {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.oracle.com/index.html");
        BufferedReader in = new BufferedReader( new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
	}
}
