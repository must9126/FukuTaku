package com.fukutaku.web.config;

import java.io.IOException;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.fukutaku.web.dao","com.fukutaku.web.service"})
public class ServiceContextConfig {
	
	@Autowired
	ApplicationContext applicationContext;
	
	

	// ?��?��?��베이?�� ?���?
	@Bean
	public BasicDataSource dataSource() 
	{
		BasicDataSource datasource = new BasicDataSource();
		
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@211.238.142.251:1521:orcl");
		datasource.setUsername("c##sist");
		datasource.setPassword("dclass");
		
		return datasource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException 
	{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:com/fukutaku/web/dao/mybatis/mapper/*.xml"));
		
		return sqlSessionFactory;
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws IOException, Exception 
	{
		
		SqlSessionTemplate sqlSession =
				new SqlSessionTemplate(sqlSessionFactoryBean().getObject());
		
		
		return sqlSession;
	}
	
	
}
