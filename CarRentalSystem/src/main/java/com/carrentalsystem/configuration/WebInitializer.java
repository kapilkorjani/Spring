package com.carrentalsystem.configuration;

import javax.servlet.Filter;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.carrentalsystem.filter.AuthenticationFilter;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebApplicationInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { ApplicationConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/", "*.css" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new AuthenticationFilter() };
	}

}
