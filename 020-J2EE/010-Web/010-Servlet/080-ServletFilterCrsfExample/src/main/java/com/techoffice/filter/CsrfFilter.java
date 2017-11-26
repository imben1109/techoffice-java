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

import com.techoffice.csrf.CookieCsrfTokenRepository;

public class CsrfFilter implements Filter {
	
	private static final String CSRF_HEADER = "X-XSRF-TOKEN";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Do Nothing
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (servletRequest instanceof HttpServletRequest 
				&& servletResponse instanceof HttpServletResponse){
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			String token = CookieCsrfTokenRepository.loadToken(request, response);
			String actualToken = request.getHeader(CSRF_HEADER);
			
		}
	}

	@Override
	public void destroy() {
		// Do Nothing
	}

}
