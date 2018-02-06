package com.techoffice.example;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Appl {
	public static void main(String[] args) throws IOException, URISyntaxException{
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(new URI("http://www.google.com"));
	}
}
