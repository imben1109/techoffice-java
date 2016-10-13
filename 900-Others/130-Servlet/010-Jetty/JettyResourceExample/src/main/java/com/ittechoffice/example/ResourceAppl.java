package com.ittechoffice.example;
import java.io.File;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

public class ResourceAppl {
	public static void main(String[] args) throws Exception{
        Server server = new Server(8080);
        
        ResourceHandler resourceHandler = new ResourceHandler();
        
        ContextHandler context = new ContextHandler();
        context.setContextPath("/");
        
        File file = new File(ResourceAppl.class.getClassLoader().getResource("Testing.txt").getFile());
        context.setBaseResource(Resource.newResource(file));
        context.setHandler(resourceHandler);
        
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { context });

        server.setHandler(contexts);
        server.start();
        server.join();

	}
}
