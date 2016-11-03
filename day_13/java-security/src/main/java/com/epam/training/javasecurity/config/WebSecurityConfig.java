package com.epam.training.javasecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.epam.training.javasecurity.mvc.LoginHandlerInterceptor;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
        	.addPathPatterns("/*", "/admin/*").excludePathPatterns("/login", "/resources/**", "/forward");
	}
	



	
	
}
