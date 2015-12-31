package app;

/**
 * Created by JHP on 12/31/15.
 */

import org.eclipse.jetty.server.Server;
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

            server.setHandler(context);

            server.start();
        }
    }
