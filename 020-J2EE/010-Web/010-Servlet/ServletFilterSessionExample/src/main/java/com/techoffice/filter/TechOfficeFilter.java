package com.techoffice.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TechOfficeFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Do Nothing
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		String url = "";
		if (servletRequest instanceof HttpServletRequest){
			HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
			url = httpServletRequest.getRequestURI();
			System.out.println("Request from " + url);
			httpServletRequest.getSession();
		}
		String ipAddress = servletRequest.getRemoteAddr();
		System.out.println("IP:" + ipAddress + " Time:" +(new Date()).toString());
		//Pass request back down the filter chain
		filterChain.doFilter(servletRequest,servletResponse);
		if (!url.equals("")){
			System.out.println("Response to " + url);
		}
	}

	@Override
	public void destroy() {
		// Do Nothing
	}

}
