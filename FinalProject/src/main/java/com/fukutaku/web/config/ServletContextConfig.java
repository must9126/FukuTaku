package com.fukutaku.web.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.tiles.access.TilesAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.SimpleSpringPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan(basePackages= {"com.fukutaku.web.controller","com.fukutaku.web.controller.customer"})
@EnableWebMvc
public class ServletContextConfig implements WebMvcConfigurer
{
	
	
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() 
	{
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		resolver.setMaxUploadSize(1000*1024*1024);
		resolver.setMaxUploadSizePerFile(100*1024*1024);
		resolver.setDefaultEncoding("UTF-8");
		
		return resolver;
	}
	
	// Tiles 설정 1
//	@Bean
//	public TilesConfigurer tilesConfigurer() 
//	{
//		TilesConfigurer tilesConfigurer = new TilesConfigurer();
//		
//		tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
//		tilesConfigurer.setPreparerFactoryClass(SimpleSpringPreparerFactory.class);
//		
//		return tilesConfigurer;
//	}
	
	// Tiles 설정 2
//	@Bean
//	public UrlBasedViewResolver urlBasedViewResolver() 
//	{
//		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setViewClass(TilesView.class);
//		resolver.setOrder(1);
//		
//		return resolver;
//	}
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() 
	{
		//Resolves views ?��?��
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		
		
		return resolver;
	}
	
	//============== WebMvcConfigurer ?��?��?�� ==========================//
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) 
	{
		// TODO Auto-generated method stub
		
		StringHttpMessageConverter converter = 
					new StringHttpMessageConverter(Charset.forName("UTF-8"));
		converter.setWriteAcceptCharset(false);
		converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", Charset.forName("UTF-8"))));
		
		
		WebMvcConfigurer.super.configureMessageConverters(converters);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		// TODO Auto-generated method stub
		
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		// TODO Auto-generated method stub
		
		registry.addViewController("/").setViewName("redirect:/index");
		
		/*
		 * WebMvcConfigurer.super.addViewControllers(registry);
		 */
	}
	
	
	
}
