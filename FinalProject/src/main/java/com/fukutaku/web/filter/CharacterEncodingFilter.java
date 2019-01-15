package com.fukutaku.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	private String encoding= "UTF-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub
		
		String encoding = filterConfig.getInitParameter("encoding");
		
		if(encoding !=null) 
			this.encoding= encoding;
		
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		
		System.out.println("사전 필터 작업");
		
		request.setCharacterEncoding(this.encoding);
		chain.doFilter(request, response);
		
		
	}
	
	
}
