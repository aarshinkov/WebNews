package com.atanas.web.config;

import javax.servlet.*;
import org.springframework.web.*;
import org.springframework.web.context.support.*;
import org.springframework.web.servlet.*;

public class WebInitializer implements WebApplicationInitializer
{
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException
  {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.setConfigLocation("com.atanas.web.config");
    ctx.setServletContext(servletContext);

    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
    
    servlet.setLoadOnStartup(1);
    servlet.setAsyncSupported(true);
    servlet.addMapping("/");
  }
}
