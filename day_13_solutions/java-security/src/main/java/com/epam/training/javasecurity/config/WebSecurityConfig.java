package com.epam.training.javasecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("peter@example.com")
//					.password("password")
//					.roles("ADMIN", "USER")
//			.and()
//				.withUser("andrew@example.com")
//					.password("password")
//					.roles("USER");
//	}

	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http
		.authorizeRequests()
			.antMatchers("/resources/**").permitAll()  
			.anyRequest().authenticated()
			.and()
		.exceptionHandling()
			.accessDeniedPage("/access-denied")
			.and()
		.formLogin().loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
	



	
	
}
