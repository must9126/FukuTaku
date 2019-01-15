package com.fukutaku.web.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer 
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] 
				{
						ServletContextConfig.class
//						ServiceContextConfig.class,
//						SecurityContextConfig.class
				};
	}

	@Override
	protected String[] getServletMappings() {  // servlet-mapping
		// TODO Auto-generated method stub
		return new String[] {"/"};  
	}

	// ?��블릿 방식?�� ?��?��?��?��?�� 방식?���? ?��?��?��겠다 ?��?�� 만든 ?��?��?��?��?��.
	
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		
		CharacterEncodingFilter charactorEncodingFilter = new CharacterEncodingFilter();
		charactorEncodingFilter.setEncoding("UTF-8");
		charactorEncodingFilter.setForceEncoding(true);
		
		
		
		return new Filter[] 
				{
						charactorEncodingFilter
				};
	}
	
}
