package Signup_Login;

import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ObjectifyInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ObjectifyService.begin();
        ObjectifyService.register(SignupRecord.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
