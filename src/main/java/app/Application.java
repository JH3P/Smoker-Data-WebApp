package app;

/**
 * Created by JHP on 12/31/15.
 */

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;

public class Application {
        public static void main(String[] args) throws Exception {

            final Server server = new Server(8080);

            final WebAppContext context = new WebAppContext();
            context.setContextPath("/");
            context.setResourceBase("/Users/JHP/Development/IdeaProjects/Smoker-Data-WebApp/src/main/webapp");
            context.setDescriptor("/Users/JHP/Development/IdeaProjects/Smoker-Data-WebApp/src/main/webapp/WEB-INF/web.xml");
            context.setParentLoaderPriority(true);
            context.setServer(server);

            ResourceHandler resource_handler = new ResourceHandler();
            resource_handler.setDirectoriesListed(false);
            resource_handler.setWelcomeFiles(new String[]{ "index.html" });
            resource_handler.setResourceBase("/Users/JHP/Development/IdeaProjects/Smoker-Data-WebApp/src/main/webapp");


            HandlerList handlers = new HandlerList();
            handlers.setHandlers(new Handler[] { resource_handler, context });
            server.setHandler(handlers);

                server.start();
                server.join();

            /*
            Server server = new Server(8080);

            WebAppContext webapp = new WebAppContext();
            webapp.setContextPath("/");
            webapp.setWar("/Users/JHP/Development/IdeaProjects/Smoker-Data-WebApp/target/SmokerDataApplication.war");
            server.setHandler(webapp);

            server.start();
            server.join();
            */
        }
    }
