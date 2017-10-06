# Servlet Listener Example

## List of Event Listener
* ServletContextListener
* ServletContextAttributeListener
* HttpSessionListener
* HttpSessionAttributeListener
* ServletRequestListener
* ServletRequestAttributeListener

### ServletContextListener
Servlet context lifecycle changes
* Servlet context creation, at which point the first request can be serviced
* Imminent shutdown of the servlet context

### ServletContextAttributeListener
Servlet context attribute changes
* Addition of servlet context attributes
* Removal of servlet context attributes
* Replacement of servlet context attributes

### HttpSessionListener
Session lifecycle changes
* Session creation
* Session invalidation
* Session timeout

### HttpSessionAttributeListener
Session attribute changes
* Addition of session attributes
* Removal of session attributes
* Replacement of session attributes

## Reference
* https://docs.oracle.com/cd/B14099_19/web.1012/b14017/filters.htm#i1000654
