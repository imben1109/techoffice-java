package com.techoffice.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techoffice.example.servlet.TechOfficeServletRequestWrapper;
import com.techoffice.example.servlet.TechOfficeServletResponseWrapper;

public class TechOfficeFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Do Nothing
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (servletRequest instanceof HttpServletRequest
				&& servletResponse instanceof HttpServletResponse){
			HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
			HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
			TechOfficeServletRequestWrapper httpServletRequestWrapper = new TechOfficeServletRequestWrapper(httpServletRequest);
			TechOfficeServletResponseWrapper httpServletResponseWrapper = new TechOfficeServletResponseWrapper(httpServletResponse);
			filterChain.doFilter(httpServletRequestWrapper, httpServletResponseWrapper);
		}else{
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		// Do Nothing
	}

}
