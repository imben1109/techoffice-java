package com.techoffice.servlet;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;

public class MultiReadableHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private String body;
	
	public MultiReadableHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		try {
			request.setCharacterEncoding("UTF-8");
			body = IOUtils.toString(request.getReader());
		} catch (IOException e) {
			body = "";
		}
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
		return new MultiReadableHttpServletInputStream(byteArrayInputStream);
	 }

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}

}
