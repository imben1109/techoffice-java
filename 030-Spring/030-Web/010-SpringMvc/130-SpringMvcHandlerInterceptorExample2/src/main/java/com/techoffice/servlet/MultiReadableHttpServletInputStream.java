package com.techoffice.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class MultiReadableHttpServletInputStream extends ServletInputStream{

	private ByteArrayInputStream byteArrayInputStream;
	
	public MultiReadableHttpServletInputStream(ByteArrayInputStream byteArrayInputStream){
		this.byteArrayInputStream = byteArrayInputStream;
	}
	
	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public boolean isReady() {
		return false;
	}

	@Override
	public void setReadListener(ReadListener arg0) {
	}

	@Override
	public int read() throws IOException {
		return byteArrayInputStream.read();
	}

}
