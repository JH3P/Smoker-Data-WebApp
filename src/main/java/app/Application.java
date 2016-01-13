package app;

/**
 * Created by JHP on 12/31/15.
 */

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.InputStream;

public class Application {
        public static void main(String[] args) throws Exception {
            final Server server = new Server(8080);

            final WebAppContext context = new WebAppContext();
            context.setContextPath("/");
            context.setResourceBase("classes");
            context.setDescriptor("classes/WEB-INF/web.xml");
//            context.setResourceBase("src/main/webapp/");
//            context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
            context.setParentLoaderPriority(true);
            context.setServer(server);
            ResourceHandler resource_handler = new ResourceHandler();
            resource_handler.setDirectoriesListed(false);
            resource_handler.setWelcomeFiles(new String[]{ "index.html" });
            resource_handler.setResourceBase("classes");
//            resource_handler.setResourceBase("src/main/webapp/");

            HandlerList handlers = new HandlerList();
            handlers.setHandlers(new Handler[] { resource_handler, context });
            server.setHandler(handlers);

            server.start();
            server.join();
        }

    }
