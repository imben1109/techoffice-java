# Jetty Example

## Jetty 
Jetty is a Java HTTP Server and a Servert Container.

## Example
```
Server server = new Server(8080);
ServletHandler handler = new ServletHandler();
server.setHandler(handler);

handler.addServletWithMapping(ApplServlet.class, "/*");

server.start();
server.join();
```