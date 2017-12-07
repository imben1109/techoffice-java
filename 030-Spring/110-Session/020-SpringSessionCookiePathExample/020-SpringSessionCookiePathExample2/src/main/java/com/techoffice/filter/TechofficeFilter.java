package com.techoffice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TechofficeFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (servletRequest instanceof HttpServletRequest 
				&& servletResponse instanceof HttpServletResponse){
//			HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//			HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//			HttpSession httpSession = httpServletRequest.getSession(true);
//			httpSession.setAttribute("testing", "sample2");
//			System.out.println(httpSession.getId());
//			httpServletResponse.getWriter().println(httpSession.getAttribute("testing"));
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
