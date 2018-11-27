package jee.web.shoppee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import jee.web.shoppee.factory.ApplicationFactory;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationFactory.instantiate();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
