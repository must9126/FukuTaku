package com.fukutaku.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
			.antMatchers("/admin/**")  // /admin/ url??
				.hasAnyRole("ADMIN")  // ROLE_ADMIN ?ù∏ Î©§Î≤ÑÎß? ?ì§?ñ¥?ò®?ã§.
			.antMatchers("/teacher/**")
				.hasAnyRole("TEACHER")
			.and()  //?úÑ ?Ñ§?†ï?ùÑ ?Åù?Ç¥Í≥?
		.formLogin()
			.loginPage("/member/login")
			.loginProcessingUrl("/member/login")
			.defaultSuccessUrl("/index")
			.and()
		.logout()
			.logoutUrl("/member/logout")
			.logoutSuccessUrl("/index")
			.invalidateHttpSession(true)
			.and()
		.csrf()
			.disable();
			
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*   <user-service >
		 *  auth
		 *  	.inMemoryAuthentication()
			 *  	.withUser("newlec")
			 *  		.password("{noop}111")
			 *  		.roles("ADMIN")
			 *  	.and()
			 *  	.withUser("dragon")
			 *  		.password("{noop}111")
			 *  		.roles("TEACHER");
		 * */
		
		//<jdbc-user-service
		auth
			.jdbcAuthentication()
			.passwordEncoder(new BCryptPasswordEncoder())
			.dataSource(dataSource)
			.usersByUsernameQuery("SELECT ID, PWD PASWORD, 1 ENABLED FROM MEMBER WHERE ID=?")
			.authoritiesByUsernameQuery("SELECT MEMBER_ID ID, ROLE_ID ROLEID FROM MEMBER_ROLE WHERE MEMBER_ID=?");
			
		
		
		
		
	}
	
}
