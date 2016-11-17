package com.ittechoffice.example.handler;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TestHandler implements HttpHandler {

	public void handle(HttpExchange httpExchange) throws IOException {
        String response = "This is test response";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();		
	}

}
