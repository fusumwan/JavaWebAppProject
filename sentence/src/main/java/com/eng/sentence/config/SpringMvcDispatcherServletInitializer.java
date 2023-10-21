
package com.eng.sentence.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.eng.sentence.config.*;
public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
     * The getRootConfigClasses method should return configuration classes annotated with @Configuration. These classes will configure the root ApplicationContext of the application, usually some service, database, etc.
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }
    /*
     * The getServletConfigClasses method should return configuration classes annotated with @Configuration. These classes will configure the ApplicationContext of the DispatcherServlet, usually some controllers, view resolvers, etc.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

