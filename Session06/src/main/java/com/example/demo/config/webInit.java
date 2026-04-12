package com.example.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class webInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // pas de root context
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{com.example.demo1.config.appConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // DispatcherServlet map tout
    }
}