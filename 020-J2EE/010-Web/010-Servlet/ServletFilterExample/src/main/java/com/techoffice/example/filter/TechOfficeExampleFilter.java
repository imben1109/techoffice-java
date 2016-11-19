package com.techoffice.example.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TechOfficeExampleFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Do Nothing
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		String ipAddress = servletRequest.getRemoteAddr();
		System.out.println("IP:" + ipAddress + " Time:" +(new Date()).toString());
		//Pass request back down the filter chain
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {
		// Do Nothing
	}

}
