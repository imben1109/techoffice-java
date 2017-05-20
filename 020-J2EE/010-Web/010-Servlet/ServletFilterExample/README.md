# Servlet Filter Example

```
<servlet>
<servlet-name>TechOfficeExampleServlet</servlet-name>
<servlet-class>com.techoffice.example.servlet.TechOfficeExampleServlet</servlet-class>
</servlet>

<filter>
<filter-name>TechOfficeExampleFilter</filter-name>
<filter-class>com.techoffice.example.filter.TechOfficeExampleFilter</filter-class>
</filter>

<servlet-mapping>
<servlet-name>TechOfficeExampleServlet</servlet-name>
<url-pattern>/*</url-pattern>
</servlet-mapping>

<filter-mapping>
<filter-name>TechOfficeExampleFilter</filter-name>
<url-pattern>/*</url-pattern>
</filter-mapping>
```

TechofficeExampleFilter
```
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
```