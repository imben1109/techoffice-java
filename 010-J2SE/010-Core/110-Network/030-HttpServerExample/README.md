Since Java SE 1.6, a built-in light HTTP server is shipped with Java Runtime. i.e. com.sun.net.httpserver.HttpServer

```
	int port = 8080;
	HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
	server.createContext("/", new RootHandler());
	server.createContext("/test", new TestHandler());
	server.setExecutor(null); 

	System.out.println("Simple Http Server is running on " + port);

	server.start();
```

```
public class RootHandler implements HttpHandler {

	public void handle(HttpExchange httpExchange) throws IOException {
        String response = "This is http response";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();		
	}

}
```