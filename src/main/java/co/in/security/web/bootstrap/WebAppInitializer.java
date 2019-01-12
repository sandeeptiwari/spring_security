package co.in.security.web.bootstrap;

import co.in.security.web.config.RootConfiguration;
import co.in.security.web.config.WebMvcConfig;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Replaces web.xml.txt in Servlet v.3.0+
 *
 * @see
 */
@Order(1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(final ServletContext servletContext)
            throws ServletException {

        // Register DispatcherServlet
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebMvcConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
                new DispatcherServlet(ctx)); // <-- hooray! Spring doesn't look for XML files!
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

        // Register H2 Admin console:
/*
        ServletRegistration.Dynamic h2WebServlet = servletContext.addServlet("h2WebServlet",
                "org.h2.server.web.WebServlet");
        h2WebServlet.addMapping("/admin/h2/*");
        h2WebServlet.setInitParameter("webAllowOthers", "true");
*/

    }
}
